
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class TotalSalary {

    public static void main(String[] args) throws Exception {
        
        String sql="select sum(sal) from emp";
        Connection con=Utility.connect();
        PreparedStatement ps=con.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        rs.next();
        String result=rs.getString(1);
        System.out.println("Total Salary  : "+result);
        
        /*
        String sql="select sal from emp";
        Connection con=Utility.connect();
        PreparedStatement ps=con.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        int sum=0;
        
        while(rs.next()){
            sum=sum+rs.getInt(1);
        }
        
        System.out.println("Total Salary : "+sum);
        
        con.close();
        */
    }   
}
