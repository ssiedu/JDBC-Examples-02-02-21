
import java.sql.Connection;
import java.sql.DatabaseMetaData;


public class DatabaseMetaDataExample {

    public static void main(String[] args) throws Exception {
        Connection con=Utility.connect();
        DatabaseMetaData dbmd=con.getMetaData();
        String pname=dbmd.getDatabaseProductName();
        String pversion=dbmd.getDatabaseProductVersion();
        String dname=dbmd.getDriverName();
        String dversion=dbmd.getDriverVersion();
        System.out.println("Product Name : "+pname);
        System.out.println("Product Version : "+pversion);
        System.out.println("Driver Name : "+dname);
        System.out.println("Driver Version : "+dversion);
        con.close();
    }
}
