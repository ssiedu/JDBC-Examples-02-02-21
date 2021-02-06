
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class UserAuth {

    public static void main(String[] args) throws Exception {
        
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Enter Userid : ");
        String id=sc.next();
        
        
        String sql="SELECT * FROM users WHERE userid=?";
        
        Connection con=Utility.connect();
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1, id);
        //ps.setString(2, pw);
        ResultSet rs=ps.executeQuery(); 
        boolean found=rs.next();    //will try to move cursor from BeforeFirst=>First
        
        //found=true indicates cursor reached to 1st row, found=false indicates 1st row not exists (rs is empty)
        
        if(found==true){
            System.out.println("Enter Password : ");
            String pw=sc.next();
            String password=rs.getString("password");
            if(password.equals(pw)){
                System.out.println("Welcome User...");
            }else{
                System.out.println("Invalid Password...");
            }
        }else{
            System.out.println("Invalid Userid...");
        }
        
        con.close();
        
    }
}
