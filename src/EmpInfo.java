
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class EmpInfo {

    public static void main(String[] args) throws Exception {

        Connection con=Utility.connect();
        String sql="SELECT * FROM emp";
        PreparedStatement ps=con.prepareCall(sql);
        ResultSet rs=ps.executeQuery();
        while(true){
            boolean b=rs.next();
            if(b==false)break;
            String s1=rs.getString("eno");
            String s2=rs.getString("ename");
            String s3=rs.getString("sal");
            System.out.println(s1+"\t"+s2+"\t"+s3);
                    
        }
        
        
        con.close();
    }
}
