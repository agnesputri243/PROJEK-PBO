import java.util.ArrayList;
import java.util.List;

public class Bengkel {
    protected String namaBengkel;
    protected String alamatBengkel;
    protected List<Servis> daftarServis;

    // konstruktor
    public Bengkel(String namaBengkel, String alamatBengkel) {
        this.namaBengkel = namaBengkel;
        this.alamatBengkel = alamatBengkel;
        this.daftarServis = new ArrayList<>();
    }

    // getter
    public String getNamaBengkel() {
        return namaBengkel;
    }

    public String getAlamatBengkel() {
        return alamatBengkel;
    }

    public List<Servis> getDaftarServis() {
        return daftarServis;
    }

    // setter
    public void setNamaBengkel(String namaBengkel) {
        this.namaBengkel = namaBengkel;
    }

    public void setAlamatBengkel(String alamatBengkel) {
        this.alamatBengkel = alamatBengkel;
    }

    // + servis ke daftar
    public void tambahServis(Servis servis) {
        daftarServis.add(servis);
    }

    // tampilan semua servis 
    public void tampilkanDaftarServis() {
        System.out.println("Daftar Servis di " + namaBengkel + ":");
        for (Servis servis : daftarServis) {
            servis.cetakDetailServis();
        }
    }
}
