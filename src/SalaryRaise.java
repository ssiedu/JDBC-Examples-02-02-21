
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class SalaryRaise {

    public static void main(String[] args) throws Exception {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Code   : ");
        int code=sc.nextInt();
        System.out.println("Enter Amount : ");
        int amt=sc.nextInt();
        Connection con=Utility.connect();
        String sql="UPDATE emp SET sal=sal+? WHERE eno=?";
        
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1, amt);
        ps.setInt(2, code);
        int n=ps.executeUpdate();
        
        System.out.println(n+" rows modified....");
        con.close();
    }
}
