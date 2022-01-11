package Entity;

public class ManusiaEntity {
    protected String nama, noTelp;

    public ManusiaEntity() {}

    public ManusiaEntity(String nama, String noTelp) {
        this.nama = nama;
        this.noTelp = noTelp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }
    
}
