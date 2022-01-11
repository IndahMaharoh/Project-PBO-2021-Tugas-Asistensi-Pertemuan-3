package Entity;

public class AdminEntity extends ManusiaEntity{
    private String password, id;

    public AdminEntity(String password, String id, String nama, String noTelp) {
        super(nama, noTelp);
        this.password = password;
        this.id = id;
    }

    public AdminEntity() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
