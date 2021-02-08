
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class EmpBranchInfo {

    public static void main(String[] args) throws Exception {

        //here we wish to display name each emp along with his bname
        
        String sql="SELECT ename,bname from emp,branch where emp.bcode=branch.bcode";
        
        Connection con=Utility.connect();
        PreparedStatement ps=con.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            String s1=rs.getString(1);  //ename
            String s2=rs.getString(2);  //bname
            System.out.println(s1+"\t"+s2);
        }
        con.close();
    }
}
