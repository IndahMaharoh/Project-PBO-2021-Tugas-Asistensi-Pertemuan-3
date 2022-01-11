package Model;
import Entity.*;
import Helper_07342.KoneksiDb_07342;
import java.sql.*;
import java.util.ArrayList;

public class TransaksiModel {
    private String sql;
    public Connection conn = KoneksiDb_07342.getconection();
    public ArrayList<TransaksiEntity> Transaksi = new ArrayList<>();
    public ArrayList<ProdukEntity> Produk = new ArrayList<>();
    
    public TransaksiModel() {}//construktor
    
    public void insertDataPembeli(TransaksiEntity Transaksi){
        try{
            sql="INSERT INTO transaksi (Nomortrx, namaAkun, IDGame, nama, noTelp, nominal, namaProduk, harga, status) Values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, Transaksi.getNomortrx());
            stat.setString(2, Transaksi.pembeli.getNamaakun());
            stat.setString(3, Transaksi.pembeli.getIDGame());
            stat.setString(4, Transaksi.pembeli.getNama());
            stat.setString(5, Transaksi.pembeli.getNoTelp());
            stat.setString(6, Transaksi.produk.getNominal());
            stat.setString(7, Transaksi.produk.getNamaproduk());
            stat.setString(8, Transaksi.produk.getHarga());
            stat.setBoolean(9, Transaksi.isStatustrx());
            
            int rows=stat.executeUpdate();
            System.out.println(rows + "row(s) updated !");
        }catch(SQLException e){
            System.out.println("GAGAL INPUT DATA !!!");
            e.printStackTrace();
        }
    }

    public ArrayList<TransaksiEntity> showData(int index)
    {
        try{
            sql = "SELECT * FROM transaksi where Nomortrx = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, index);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                TransaksiEntity transaksi = new TransaksiEntity();
                PembeliEntity pembeli = new PembeliEntity();
                ProdukEntity produk = new ProdukEntity();
                transaksi.setNomortrx(rs.getInt("Nomortrx"));
                pembeli.setIDGame(rs.getString("IDGame"));
                pembeli.setNama(rs.getString("nama"));
                pembeli.setNoTelp(rs.getString("noTelp"));
                pembeli.setNamaakun(rs.getString("namaAkun"));
                transaksi.setPembeli(pembeli);
                produk.setNominal(rs.getString("nominal"));
                produk.setNamaproduk(rs.getString("namaProduk"));
                produk.setHarga(rs.getString("harga"));
                transaksi.setProduk(produk);
                transaksi.setStatustrx(rs.getBoolean("status"));
                Transaksi.add(transaksi);
            }
            }catch(SQLException e){
                System.out.println(e);
            }
        return Transaksi;
    }
    
    public void insertProduk(ProdukEntity produk){
        try{
            sql="INSERT INTO produk (namaProduk, nominal, harga) Values(?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, produk.getNamaproduk());
            stat.setString(2, produk.getNominal());
            stat.setString(3, produk.getHarga());
            
            int rows=stat.executeUpdate();
            System.out.println(rows + "row(s) updated !");
        }catch(SQLException e){
            System.out.println("GAGAL INPUT DATA !!!");
            e.printStackTrace();
        }
    }
    
    public void deleteData(int index){
        try {
            sql = "DELETE FROM transaksi where Nomortrx =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, index);
            stat.executeUpdate();
        } catch (SQLException e) {
            System.out.println("GAGAL Hapus DATA!!!");
        }
    }
    
    public void cari(String nomortrx){
        String cek;
        try {
            sql = "SELECT * FROM transaksi where id = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, nomortrx);
            ResultSet rs = stat.executeQuery();
            if(rs.next()){
                cek = rs.getString("id");
                String nama = rs.getString("nama");
                System.out.println("Selamat Datang " + nama);
            } else {
                System.out.println("ID/PASSWORD SALAH/ADMIN BELUM ADA ");
            }
        } catch (Exception e){
            e.printStackTrace();
        } 
    }
    
    public void updatetrx(int index, TransaksiEntity Transaksi){
        try {
            sql = "UPDATE transaksi SET namaAkun =? WHERE Nomortrx =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, Transaksi.pembeli.getNamaakun());
            stat.setInt(2, index);
            stat.executeUpdate();
        } catch(SQLException e) {
            System.out.println("GAGAL RUBAH NOMORTRX!!!");
            System.out.println(e);
        }
    }
    
}
