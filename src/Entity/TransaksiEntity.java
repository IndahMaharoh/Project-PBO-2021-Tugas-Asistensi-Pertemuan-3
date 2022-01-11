package Entity;
import Entity.*;

public class TransaksiEntity {
    protected int nomortrx;
    protected boolean statustrx;
    public PembeliEntity pembeli;
    public ProdukEntity produk;

    public TransaksiEntity(int nomortrx, boolean statustrx, PembeliEntity pembeli, ProdukEntity produk) {
        this.nomortrx = nomortrx;
        this.statustrx = statustrx;
        this.pembeli = pembeli;
        this.produk = produk;
    }

    public TransaksiEntity() {}

    public boolean isStatustrx() {
        return statustrx;
    }

    public void setStatustrx(boolean statustrx) {
        this.statustrx = statustrx;
    }

    public int getNomortrx() {
        return nomortrx;
    }

    public void setNomortrx(int nomortrx) {
        this.nomortrx = nomortrx;
    }

    public PembeliEntity getPembeli() {
        return pembeli;
    }

    public void setPembeli(PembeliEntity pembeli) {
        this.pembeli = pembeli;
    }

    public ProdukEntity getProduk() {
        return produk;
    }

    public void setProduk(ProdukEntity produk) {
        this.produk = produk;
    }

}
