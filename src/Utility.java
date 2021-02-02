
import java.sql.Connection;
import java.sql.DriverManager;

public class Utility {

    public static Connection connect() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        //System.out.println("Driver Loaded");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/batch5", "root", "root");
        //System.out.println("Connected..");
        return con;
    }
    public static void main(String[] args) throws Exception {
        connect();
    }
}
