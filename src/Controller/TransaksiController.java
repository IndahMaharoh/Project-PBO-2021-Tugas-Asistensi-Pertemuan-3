package Controller;
import Entity.*;
import Model.*;
import java.util.ArrayList;

public class TransaksiController {
    public void insertDataPembeli(int nomortrx, PembeliEntity pembeli, ProdukEntity produk, boolean statustrx){
        TransaksiEntity transaksi = new TransaksiEntity();
        transaksi.setNomortrx(nomortrx);
        transaksi.setPembeli(pembeli);
        transaksi.setProduk(produk);
        transaksi.setStatustrx(statustrx);
        ObjectModelController.transaksi.insertDataPembeli(transaksi);
    }

    public TransaksiController() {}//CONSTRUCTOR
    
    public void insertProduk(String namaproduk, String nominal, String harga){
        ProdukEntity produk = new ProdukEntity();
        produk.setNamaproduk(namaproduk);
        produk.setNominal(nominal);
        produk.setHarga(harga);
        ObjectModelController.transaksi.insertProduk(produk);
    }
    public ArrayList<TransaksiEntity> showData(int index){
        return ObjectModelController.transaksi.showData(index);
    }
    public void delete(int index){
        ObjectModelController.transaksi.deleteData(index);
    }
    public void updateNA(int index, TransaksiEntity Transaksi){
        ObjectModelController.transaksi.updatetrx(index, Transaksi);
    }
    public void cari(String nomortrx){
        ObjectModelController.transaksi.cari(nomortrx);
    }
}
