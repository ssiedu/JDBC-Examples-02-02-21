
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class EmpInfo {

    public static void main(String[] args) throws Exception {

        Connection con=Utility.connect();
        String sql="SELECT * FROM emp";
        PreparedStatement ps=con.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        
        //initially cursor is placed on before-first position
        
        //String s=rs.getString(1);
        System.out.println("Ecode\tEname\tSal\tbonus");
        while(true){
            boolean b=rs.next();
            if(b==false)break;
            String s1=rs.getString(1);
            String s2=rs.getString(2);
            //String s3=rs.getString(3);    //"10000"
            int s3=rs.getInt(3);            //10000
            //we need to compute bonus also (which is 10% of salary)
            int bonus=s3*10/100;
           
            System.out.println(s1+"\t"+s2+"\t"+s3+"\t"+bonus);
                    
        }
        
        
        con.close();
    }
}
