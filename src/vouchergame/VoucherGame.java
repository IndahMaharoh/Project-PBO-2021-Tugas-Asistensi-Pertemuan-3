package vouchergame;
import Entity.*;
import Controller.*;
import java.util.Scanner;

public class VoucherGame {
    public static Scanner input =new Scanner(System.in);
    public static TransaksiController trx = new TransaksiController();
    public static PembeliController pembeli = new PembeliController();
    public static AdminController admin = new AdminController();
    public static AdminEntity a = new AdminEntity();
    public static PembeliEntity pem = new PembeliEntity();
    public static ProdukEntity pro = new ProdukEntity();
    public static TransaksiEntity tr = new TransaksiEntity();
    
    public static int nomortrx;
    
    public static void main(String[] args) {
        int pil;
        do{
        System.out.println("1. Transaksi");
        System.out.println("2. Via Admin");
        System.out.println("3. Via Pembeli");
        System.out.println("4. Keluar");
        System.out.print("Masukan Pilihan : ");
        pil = input.nextInt();
            switch(pil){
            case 1 : transaksi(); break;
            case 2 : viaAdmin(); break;
            case 3 : viaPembeli(); break;
            default : System.out.println("Pilihan Tidak Tersedia"); break;
        }
        }while(pil<=3);
    }
    
    public static void transaksi(){
        int pil;
        do{
            System.out.println("\tTransaksi");
            System.out.println("1. Tambah Data Transaksi");
            System.out.println("2. Lihat Data Transaksi");
            System.out.println("3. Beli Produk");
            System.out.println("4. Keluar");
            System.out.print("Masukan pilihan Anda : ");
            pil = input.nextInt();
            switch(pil){
            case 1 :
                proses(); break;
            case 2 :
                System.out.print("Masukan nomor transaksi : ");
                nomortrx = input.nextInt();
                for (TransaksiEntity transaksi : trx.showData(nomortrx)){
                        System.out.println("----------------------------");
                        System.out.println("Nomor transaksi : " + transaksi.getNomortrx());
                        System.out.println("Nama : " + transaksi.pembeli.getNama());
                        System.out.println("ID Game : " + transaksi.pembeli.getIDGame());
                        System.out.println("No. Telepon : " + transaksi.pembeli.getNoTelp());
                        System.out.println("Nama Akun : " + transaksi.pembeli.getNamaakun());
                        System.out.println("Nominal : " + transaksi.produk.getNominal());
                        System.out.println("Nama Produk : " + transaksi.produk.getNamaproduk());
                        System.out.println("Harga : " + transaksi.produk.getHarga());
                        System.out.println("Status : " + transaksi.isStatustrx());
                }
                break;
            case 3 :
                System.out.print("Nama Produk : ");
                String np = input.next();
                pro.setNamaproduk(np);
                System.out.print("Nominal : ");
                String nom = input.next();
                pro.setNominal(nom);
                System.out.print("Harga : ");
                String price = input.next();
                pro.setHarga(price);
                trx.insertProduk(np, nom, price);
                break;
            default :
                System.out.println("Berhasil Keluar");
                break;
        }
        }while(pil<=3);
    }
    
    public static void viaAdmin(){
        int pil;
        System.out.println("Login");
        System.out.print("Masukan id : ");
        String id = input.next();
        System.out.print("Masukan password : ");
        String password = input.next();
        admin.login(id, password);
        do{
            System.out.println("\tMenu Pilihan ");
            System.out.println("1. Tambah Data Admin ");
            System.out.println("2. Lihat Data Admin ");
            System.out.println("3. Update Nama Akun pada Data Transaksi ");
            System.out.println("4. Hapus Data Transaksi ");
            System.out.println("5. Keluar");
            System.out.print("Masukan pilihan Anda : ");
            pil = input.nextInt();
            switch(pil){
                case 1 : 
                    System.out.print("Nama : ");
                    String nama = input.next();
                    a.setNama(nama);
                    System.out.print("id : ");
                    String idA = input.next();
                    a.setId(idA);
                    System.out.print("Password : ");
                    String PASS = input.next();
                    a.setPassword(PASS);
                    System.out.print("No.Telepon : ");
                    String noTelpA = input.next();
                    a.setNoTelp(noTelpA);
                    admin.adminEntity(a); break;
                case 2 : 
                    for (AdminEntity admin : admin.showDataAdminEntity(id)){
                        System.out.println("----------------------------");
                        System.out.println("Nama : " + admin.getNama());
                        System.out.println("id : " + admin.getId());
                        System.out.println("Password : " + admin.getPassword());
                        System.out.println("No. Telepon : " + admin.getNoTelp());
                    }
                    break;
                case 3 : 
                    TransaksiEntity trans = new TransaksiEntity();
                    System.out.print("Masukan nomortrx pada nama akun yang ingin diupdate : ");
                    nomortrx =input.nextInt();
                    System.out.print("Masukan Nama Akun Baru : ");
                    String namaA = input.next();
                    pem.setNamaakun(namaA);
                    trans.setPembeli(pem);
                    trx.updateNA(nomortrx, trans);
                    break;
                case 4 : 
                    System.out.print("Masukan nomortrx yang ingin dihapus : ");
                    int nomor =input.nextInt();
                    admin.delete(nomor);
                    break;
                default : 
                    System.out.println("Berhasil Keluar"); break;
            }
        }while(pil<=4);
        
    }
    public static void viaPembeli(){
        int pil;
        do{
            System.out.println("\tMenu Pilihan ");
            System.out.println("1. Daftar ");
            System.out.println("2. Lihat Data Pembeli ");
            System.out.println("3. Keluar");
            System.out.print("Masukan pilihan Anda : ");
            pil = input.nextInt();
            switch(pil){
                case 1 : 
                    System.out.print("ID Game : ");
                    String IDP = input.next();
                    pem.setIDGame(IDP);
                    System.out.print("Nama : ");
                    String nama = input.next();
                    pem.setNama(nama);
                    System.out.print("No.Telepon : ");
                    String noTelp = input.next();
                    pem.setNoTelp(noTelp);
                    System.out.print("Nama Akun : ");
                    String namaA = input.next();
                    pem.setNamaakun(namaA);
                    pembeli.daftar(pem); break;
                case 2 : 
                    System.out.println("Login");
                    System.out.print("Masukan IDGame : ");
                    String id = input.next();
                    pembeli.loginPembeli(id);
                    for (PembeliEntity pembeli : pembeli.pembeliEntity(id)){
                        System.out.println("----------------------------");
                        System.out.println("ID Game : " + pembeli.getIDGame());
                        System.out.println("Nama : " + pembeli.getNama());
                        System.out.println("No. Telepon  : " + pembeli.getNoTelp());
                        System.out.println("Nama Akun : " + pembeli.getNamaakun());
                    }
                    break;
                default : 
                    System.out.println("Berhasil Keluar"); break;
            }
        }while(pil<=2);
    }
    public static void proses(){
        TransaksiEntity trans = new TransaksiEntity();
        System.out.print("Nomor Transaksi : ");
        int nmr = input.nextInt();
        trans.setNomortrx(nomortrx);
        System.out.print("ID Game : ");
        String id = input.next();
        pem.setIDGame(id);
        System.out.print("Nama : ");
        String nama = input.next();
        pem.setNama(nama);
        System.out.print("No.Telepon : ");
        String noTelp = input.next();
        pem.setNoTelp(noTelp);
        System.out.print("Nama Akun : ");
        String namaA = input.next();
        pem.setNamaakun(namaA);
        trans.setPembeli(pem);
        System.out.print("Nama Produk : ");
        String namaP = input.next();
        pro.setNamaproduk(namaP);
        System.out.print("Nominal : ");
        String nominal = input.next();
        pro.setNominal(nominal);
        System.out.print("Harga : ");
        String harga = input.next();
        pro.setHarga(harga);
        trans.setProduk(pro);
        System.out.print("Status : ");
        boolean status = input.hasNext();
        trans.setStatustrx(status);
        trx.insertDataPembeli(nmr, pem, pro, status);
    }
}
 