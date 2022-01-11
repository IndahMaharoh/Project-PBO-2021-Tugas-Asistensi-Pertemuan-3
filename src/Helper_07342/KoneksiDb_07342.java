package Helper_07342;
import java.sql.*;

public class KoneksiDb_07342 {    
    public static Connection getconection(){
        Connection conn = null;
        String driver_Indah = "com.mysql.cj.jdbc.Driver";
        String url_Indah = "jdbc:mysql://localhost:3306/VG";
        String user_Indah = "root";
        String pass_Indah ="";
        try{
            Class.forName(driver_Indah);
            conn=DriverManager.getConnection(url_Indah, user_Indah, pass_Indah);
            System.out.println("Berhasil Koneksi Database");
        }catch(Exception e){
            System.out.println("Gagal Koneksi Database");
            e.printStackTrace();
        }
        return conn;
    }
}
