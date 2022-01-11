package Model;
import Entity.AdminEntity;
import Helper_07342.KoneksiDb_07342;
import java.sql.*;
import java.util.ArrayList;

public class AdminModel {
    private String sql;
    public Connection conn = KoneksiDb_07342.getconection();
    public ArrayList<AdminEntity> AdminEntity = new ArrayList<>();
        
    public AdminModel() {}//construktor
    
    public void insertData(AdminEntity admin){
        try{
            sql="INSERT INTO admin (nama, id,password, noTelp) Values(?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, admin.getNama());
            stat.setString(2, admin.getId());
            stat.setString(3, admin.getPassword());
            stat.setString(4, admin.getNoTelp());
            
            int rows=stat.executeUpdate();
            System.out.println(rows + "row(s) updated !");
        }catch(SQLException e){
            System.out.println("GAGAL INPUT DATA !!!");
            e.printStackTrace();
        }
    }
    
    public void cekData(String id, String password){
        String cek;
        try {
            sql = "SELECT *FROM admin where id =? and password = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, id);
            stat.setString(2, password);
            ResultSet rs = stat.executeQuery();
            if(rs.next()){
                cek = rs.getString("id");
                password = rs.getString("password");
                String nama = rs.getString("nama");
                System.out.println("Selamat Datang " + nama);
            } else {
                System.out.println("ID / Password salah / Belum terdaftar sebagai admin");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<AdminEntity> showDataAdminEntity(String index){
        try{
            sql = "SELECT *FROM admin where id = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, index);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                AdminEntity admin = new AdminEntity();
                admin.setNama(rs.getString("nama"));
                admin.setId(rs.getString("id"));
                admin.setPassword(rs.getString("password"));
                admin.setNoTelp(rs.getString("noTelp"));
                AdminEntity.add(admin);
            }
        }catch(SQLException e){
                System.out.println(e);
        } return AdminEntity;
    }
   
}
