
//import java.sql.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class SalaryIncrement {

    public static void main(String[] args) throws Exception {

        //Class.forName("com.mysql.jdbc.Driver"); //driver loading
        //Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/batch5", "root", "root");
        Connection con=Utility.connect();
        String sql="UPDATE emp SET sal=sal-1000";
        Statement stmt=con.createStatement();
        int n=stmt.executeUpdate(sql);
        con.close();
        System.out.println(n+ " rows modified....");
    }
}
