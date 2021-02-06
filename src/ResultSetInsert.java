
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class ResultSetInsert {
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
         System.out.println("Adding a new row ... !! ");
         Scanner sc=new Scanner(System.in);
         System.out.println("Enter Code : ");
         int code=sc.nextInt();
         System.out.println("Enter Name : ");
         String name=sc.next();
         System.out.println("Enter Sal  : ");
         int sal=sc.nextInt();
         rs.moveToInsertRow();
         rs.updateInt(1, code); rs.updateString(2, name); rs.updateInt(3, sal);
         rs.insertRow();
         System.out.println("New Result Set....");
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
