import java.sql.ResultSetMetaData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ResultSetMetaDataExample {

    public static void main(String[] args) throws Exception {
        Connection con=Utility.connect();
        PreparedStatement ps=con.prepareStatement("SELECT * FROM emp");
        ResultSet rs=ps.executeQuery();
        ResultSetMetaData rsmd=rs.getMetaData();
        int n=rsmd.getColumnCount();
        System.out.println("________________________________________________________________");
        for(int i=1; i<=n; i++){
            System.out.print(rsmd.getColumnName(i)+"\t");
        }
        System.out.println();
        System.out.println("________________________________________________________________");
        while(rs.next()){
            for(int i=1; i<=n; i++){
                System.out.print(rs.getString(i)+"\t");
            }
            System.out.println();
        }
        System.out.println("________________________________________________________________");
        con.close();
    }
    
}
