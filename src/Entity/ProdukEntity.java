package Entity;

public class ProdukEntity {
    protected String nominal,namaproduk, harga;

    public ProdukEntity(String nominal, String namaproduk, String harga) {
        this.nominal = nominal;
        this.namaproduk = namaproduk;
        this.harga = harga;
    }

    public ProdukEntity() {}

    public String getNominal() {
        return nominal;
    }

    public void setNominal(String nominal) {
        this.nominal = nominal;
    }

    public String getNamaproduk() {
        return namaproduk;
    }

    public void setNamaproduk(String namaproduk) {
        this.namaproduk = namaproduk;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }
        
}
