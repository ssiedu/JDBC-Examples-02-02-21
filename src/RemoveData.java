
import java.sql.Connection;
import java.sql.Statement;


public class RemoveData {

    public static void main(String[] args) throws Exception {

        Connection con=Utility.connect();
        Statement stmt=con.createStatement();
        int n=stmt.executeUpdate("DELETE FROM emp");
        System.out.println(n+" rows removed...");
        con.close();
    }
}
