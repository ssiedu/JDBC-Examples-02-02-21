
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class ResultSetUpdation {

    public static void main(String[] args) throws Exception {
        Connection con=Utility.connect();
        Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs=stmt.executeQuery("SELECT * FROM emp");
        while(rs.next()){
            String s1=rs.getString(1);
            String s2=rs.getString(2);
            String s3=rs.getString(3);
            System.out.println(s1+","+s2+","+s3);
        }
        System.out.println("Making Changes....");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter The Row TO Be Changed...");
        int row=sc.nextInt();
        System.out.println("Enter New Salary...");
        int newsal=sc.nextInt();
        //changing the sal of 3rd row
        //step-1 moving cursor to row-3
        rs.absolute(row); 
        //step-2 calling updatter method
        rs.updateInt("sal",newsal);
        //step-3 save the changes to db
        rs.updateRow();
        System.out.println("_______________________________________");
        System.out.println("Updated-Result-Set...");
        rs.beforeFirst();
        while(rs.next()){
            String s1=rs.getString(1);
            String s2=rs.getString(2);
            String s3=rs.getString(3);
            System.out.println(s1+","+s2+","+s3);
        }
        
        
        
        con.close();
    }
}
