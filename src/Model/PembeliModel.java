package Model;
import Entity.PembeliEntity;
import Helper_07342.KoneksiDb_07342;
import java.sql.*;
import java.util.ArrayList;

public class PembeliModel {
    private String sql;
    public Connection conn = KoneksiDb_07342.getconection();
    public ArrayList<PembeliEntity> PembeliEntity = new ArrayList<>();
    public PembeliModel() {}//construktor
    
    public ArrayList<PembeliEntity> getPembeliEntity(){
        try{
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM pembeli";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()){
                PembeliEntity pembeli = new PembeliEntity();
                pembeli.setIDGame(rs.getString("IDGame"));
                pembeli.setNama(rs.getString("nama"));
                pembeli.setNoTelp(rs.getString("noTelp"));
                pembeli.setNamaakun(rs.getString("namaAkun"));
            }
        }catch(SQLException e){
                System.out.println(e);
        }
        return PembeliEntity;        
    }
    
    public void insertData(PembeliEntity PembeliEntity){
        try{
            sql="INSERT INTO pembeli (IDGame, nama, noTelp, namaAkun) Values(?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, PembeliEntity.getIDGame());
            stat.setString(2, PembeliEntity.getNama());
            stat.setString(3, PembeliEntity.getNoTelp());
            stat.setString(4, PembeliEntity.getNamaakun());
            
            int rows=stat.executeUpdate();
            System.out.println(rows + "row(s) updated !");
        }catch(SQLException e){
            System.out.println("GAGAL INPUT DATA !!!");
            e.printStackTrace();
        }
    }
    
    public ArrayList <PembeliEntity> getPembeli(String index)
    {
        try{
            sql = "SELECT * FROM pembeli where IDGame = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, index);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                PembeliEntity pembeli = new PembeliEntity();
                pembeli.setIDGame(rs.getString("IDGame"));
                pembeli.setNama(rs.getString("nama"));
                pembeli.setNoTelp(rs.getString("noTelp"));
                pembeli.setNamaakun(rs.getString("namaAkun"));
                PembeliEntity.add(pembeli);
            }
            }catch(SQLException e){
                    System.out.println(e);
                    }
            return PembeliEntity;
    }
    
    public void cekData(String ID){
        String cek;
        try {
            sql = "SELECT * FROM pembeli where IDGame =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, ID);
            ResultSet rs = stat.executeQuery();
            if(rs.next()){
                cek = rs.getString("IDGame");
            } else {
                System.out.println("Data tidak ada");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
