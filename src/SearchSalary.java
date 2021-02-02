
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SearchSalary {
public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Code : ");
        int code=sc.nextInt();
        Connection con=Utility.connect();
        String sql="SELECT ename,sal FROM emp WHERE eno=?";
        PreparedStatement ps=con.prepareCall(sql);
        ps.setInt(1, code);
        ResultSet rs=ps.executeQuery();
        rs.next();
        
        String res=rs.getString(2); //will fetch sal col of c.row.
        System.out.println("Salary : "+res);
        con.close();
    }

}
