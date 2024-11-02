import java.util.ArrayList;
import java.util.List;

public class Pelanggan {
    private String nama;
    private String alamat;
    private String nomorTelepon;
    private String email;
    private List<Kendaraan> daftarKendaraan; 
    private int totalBiayaServis;

    // konstruktor
    public Pelanggan(String nama, String alamat, String nomorTelepon, String email) {
        this.nama = nama;
        this.alamat = alamat;
        this.nomorTelepon = nomorTelepon;
        this.email = email;
        this.daftarKendaraan = new ArrayList<>();
        this.totalBiayaServis = 0; 
    }

    // getter n setter 
    public void tambahKendaraan(Kendaraan kendaraan) {
        daftarKendaraan.add(kendaraan);
    }

    public void tambahBiayaServis(int biaya) {
        totalBiayaServis += biaya; 
    }

    public int getTotalBiayaServis() {
        return totalBiayaServis; 
    }

    public void tampilkanInfoPelanggan() {
        System.out.println("----------------------------------");
        System.out.println("Informasi Pelanggan");
        System.out.println("----------------------------------");
        System.out.println("Nama : " + nama);
        System.out.println("Alamat : " + alamat);
        System.out.println("Nomor Telepon : " + nomorTelepon);
        System.out.println("Email : " + email);
        System.out.println("Total Biaya Servis : Rp " + totalBiayaServis);
        System.out.println("----------------------------------");
    }
    
    public void tampilkanDaftarKendaraan() {
        for (Kendaraan kendaraan : daftarKendaraan) {
            kendaraan.tampilkanInfoKendaraan();
        }
    }
}
