
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReverseOrderData {
     public static void main(String[] args) throws Exception {

        Connection con=Utility.connect();
        String sql="SELECT * FROM emp";
        PreparedStatement ps=con.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        rs.afterLast();
        while(rs.previous()){
            String s1=rs.getString(1);
            String s2=rs.getString(2);
            String s3=rs.getString(3);
            System.out.println(s1+","+s2+","+s3);
        }
       
        con.close();
    }
}
