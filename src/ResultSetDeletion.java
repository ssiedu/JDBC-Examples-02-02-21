
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class ResultSetDeletion {
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
        System.out.println("Enter Row To Be Deleted : ");
        Scanner sc=new Scanner(System.in);
        int row=sc.nextInt();
        //step-1 (move the cursor to the row to be deleted)
        rs.absolute(row);
        //step-2 (call the deleteRow method to delete the current row)
        rs.deleteRow();
        System.out.println("ResultSet After Deletion.....");
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
