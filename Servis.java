import java.util.ArrayList;
import java.util.List;

public class Servis {
    public enum JenisServis {
        SERVICE_RINGAN,
        SERVICE_BERAT,
        SERVICE_KHUSUS
    }

    private String tanggal;
    private JenisServis jenisServis;
    private int biaya;
    private Kendaraan kendaraan;
    private List<String> komponenYangDiganti;

    // konstruktor
    public Servis(String tanggal, JenisServis jenisServis, Kendaraan kendaraan) {
        this.tanggal = tanggal;
        this.jenisServis = jenisServis;
        this.kendaraan = kendaraan;
        this.komponenYangDiganti = new ArrayList<>();
        this.biaya = hitungBiayaDasar(jenisServis); 
    }

    // getter
    public String getTanggal() {
        return tanggal;
    }

    public JenisServis getJenisServis() {
        return jenisServis;
    }

    public int getBiaya() {
        return biaya;
    }

    public Kendaraan getKendaraan() {
        return kendaraan;
    }

    // setter 
    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setJenisServis(JenisServis jenisServis) {
        this.jenisServis = jenisServis;
    }

    public void tambahKomponen(String komponen) {
        komponenYangDiganti.add(komponen);
    }

    private int hitungBiayaDasar(JenisServis jenisServis) {
        switch (jenisServis) {
            case SERVICE_RINGAN:
                return 200000; 
            case SERVICE_BERAT:
                return 500000; 
            case SERVICE_KHUSUS:
                return 750000; 
            default:
                return 0;
        }
    }

    public int hitungTotalBiaya() {
        int biayaTambahan = 0;

        for (String komponen : komponenYangDiganti) {
            switch (komponen.toLowerCase()) { 
                case "oli":
                    biayaTambahan += 100000;
                    break;
                case "filter":
                    biayaTambahan += 50000;
                    break;
                case "busi":
                    biayaTambahan += 20000;
                    break;
                default:
                    System.out.println("Komponen tidak dikenali: " + komponen);
            }
        }
        
        // mengembalikan total biaya keseluruhan
        return biaya + biayaTambahan;
    }

    public void cetakDetailServis() {
        System.out.println("----------------------------------");
        System.out.println("Detail Servis");
        System.out.println("----------------------------------");
        System.out.println("Tanggal Servis : " + tanggal);
        System.out.println("Jenis Servis : " + jenisServis);
        System.out.println("Kendaraan : " + (kendaraan != null ? kendaraan.getNama() : "Tidak tersedia"));
        System.out.println("Komponen yang Diganti : " + komponenYangDiganti);
        System.out.println("Total Biaya : Rp " + hitungTotalBiaya());
        System.out.println("----------------------------------");
        System.out.println();
    }
}
