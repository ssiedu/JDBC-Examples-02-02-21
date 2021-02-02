
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;





public class AddData {

    public static void main(String[] args) {

        try {
            //step-1 (Driver Loading)
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded...");
            //step-2 (Connection Establishment)
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/batch5", "root", "root");
            System.out.println("Connected Successfully....");
            //step-3 (Define a SQL command to do desired operation)
            //String sql="INSERT INTO EMP VALUES(111,'AAA',10000)";
            //String sql="INSERT INTO EMP VALUES(112,'BBB',20000)";
            //step-4 (Dispatch the SQL to DB Engine for execution)
            //to dispatch SQL to DB we are using Statement object
            Statement stmt=con.createStatement();
            //int n=stmt.executeUpdate(sql);
            //System.out.println(n+ " row created....");
            stmt.executeUpdate("insert into emp values(111,'aaa',10000)");
            stmt.executeUpdate("insert into emp values(112,'bbb',20000)");
            stmt.executeUpdate("insert into emp values(113,'ccc',30000)");
            stmt.executeUpdate("insert into emp values(114,'ddd',40000)");
            stmt.executeUpdate("insert into emp values(115,'eee',50000)");
            System.out.println("Some Records Added....");
            //step-5 (close the connection)
            con.close();
        } catch (ClassNotFoundException ex) {
            System.out.println("Cant Load Driver....");
        } catch (SQLException ex){
            ex.printStackTrace();   //it will show complete detail of exception
        }
        
    }
}
