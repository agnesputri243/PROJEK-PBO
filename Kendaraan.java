public class Kendaraan {
    protected String nama;
    protected String tipe;
    protected String nomorPlat;

    // konstruktor
    public Kendaraan(String nama, String tipe, String nomorPlat) {
        this.nama = nama;
        this.tipe = tipe;
        this.nomorPlat = nomorPlat;
    }

    // getter
    public String getNama() {
        return nama;
    }

    public String getTipe() {
        return tipe;
    }

    public String getNomorPlat() {
        return nomorPlat;
    }

    // setter
    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public void setNomorPlat(String nomorPlat) {
        this.nomorPlat = nomorPlat;
    }
    
    public void tampilkanInfoKendaraan() {
        System.out.println("Nama Kendaraan: " + nama);
        System.out.println("Tipe Kendaraan: " + tipe);
        System.out.println("Nomor Plat: " + nomorPlat);
    }
}
