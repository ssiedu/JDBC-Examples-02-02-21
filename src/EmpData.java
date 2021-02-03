
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmpData {
    public static void main(String[] args) throws Exception {

        Connection con=Utility.connect();
        String sql="SELECT * FROM emp";
        PreparedStatement ps=con.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        
        while(rs.next()){
            System.out.println(rs.getString(1));
        }
        //when first loop will end your cursor is on after-last pos
        //rs.first();         //1st-row
        rs.beforeFirst();
        while(rs.next()){
            System.out.println(rs.getString(2));
        }
        //when second loop will end cursor will reach to after-last pos
        rs.beforeFirst();
        while(rs.next()){
            System.out.println(rs.getString(3));
        }
        con.close();
    }
}
