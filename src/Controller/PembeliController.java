package Controller;
import Entity.*;
import java.util.ArrayList;

public class PembeliController {
    public void daftar(PembeliEntity PembeliEntity){
        ObjectModelController.pembeli.insertData(PembeliEntity);
    }
    public ArrayList <PembeliEntity> pembeliEntity(String index){
        return ObjectModelController.pembeli.getPembeli(index);
    }
    public ArrayList <PembeliEntity> getPembeliEntity(){
        return ObjectModelController.pembeli.getPembeliEntity();
    }
    public void loginPembeli(String index){
        ObjectModelController.pembeli.cekData(index);
    }
}
