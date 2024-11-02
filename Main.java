import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bengkel bengkel = new Bengkel("Bengkel Sejahtera", "Jl. Sudirman, No 1");
        
        System.out.println();
        System.out.println("Hallo Sealamat Datang di Bengkel Sejahtera");
        System.out.println();
        System.out.print("Masukkan jumlah pelanggan : ");
        int jumlahPelanggan = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println();
        List<Pelanggan> daftarPelanggan = new ArrayList<>();

        for (int i = 0; i < jumlahPelanggan; i++) {
            System.out.println("Data Pelanggan " + (i + 1));
            System.out.print("Nama : ");
            String nama = scanner.nextLine();
            System.out.print("Alamat : ");
            String alamat = scanner.nextLine();
            System.out.print("Nomor Telepon : ");
            String nomorTelepon = scanner.nextLine();
            System.out.print("Email : ");
            String email = scanner.nextLine();

            Pelanggan pelanggan = new Pelanggan(nama, alamat, nomorTelepon, email);
            daftarPelanggan.add(pelanggan);

            System.out.println();
            System.out.print("Masukkan jumlah kendaraan untuk " + nama + " : ");
            int jumlahKendaraan = scanner.nextInt();
            scanner.nextLine(); 

            for (int j = 0; j < jumlahKendaraan; j++) {
                System.out.println("Data Kendaraan " + (j + 1));
                System.out.print("Nama Kendaraan : ");
                String namaKendaraan = scanner.nextLine();
                System.out.print("Tipe Kendaraan : ");
                String tipeKendaraan = scanner.nextLine();
                System.out.print("Nomor Plat : ");
                String nomorPlat = scanner.nextLine();

                System.out.print("Apakah kendaraan ini adalah mobil? (IYA/SALAH) : ");
                String isMobilInput = scanner.nextLine().trim().toUpperCase();
                boolean isMobil = isMobilInput.equals("IYA");

                Kendaraan kendaraan;
                if (isMobil) {
                    System.out.print("Jumlah Pintu : ");
                    int jumlahPintu = scanner.nextInt();
                    scanner.nextLine(); 
                    kendaraan = new Mobil(namaKendaraan, tipeKendaraan, nomorPlat, jumlahPintu);
                } else {
                    System.out.print("Apakah motor memiliki bagasi? (IYA/SALAH) : ");
                    String memilikiBagasiInput = scanner.nextLine().trim().toUpperCase();
                    boolean memilikiBagasi = memilikiBagasiInput.equals("IYA");
                    kendaraan = new Motor(namaKendaraan, tipeKendaraan, nomorPlat, memilikiBagasi);
                }

                pelanggan.tambahKendaraan(kendaraan); 
                System.out.println();

                System.out.print("Tanggal Servis : ");
                String tanggalServis = scanner.nextLine();
                
                System.out.println("Pilih jenis servis : ");
                System.out.println("1. Service Ringan");
                System.out.println("2. Service Berat");
                System.out.println("3. Service Khusus");
                System.out.print("Masukkan pilihan Anda (1/2/3) : ");
                int pilihanServis = scanner.nextInt(); 
                scanner.nextLine(); 
                
                Servis.JenisServis jenisServis = null; 
                switch (pilihanServis) {
                    case 1:
                        jenisServis = Servis.JenisServis.SERVICE_RINGAN;
                        break;
                    case 2:
                        jenisServis = Servis.JenisServis.SERVICE_BERAT;
                        break;
                    case 3:
                        jenisServis = Servis.JenisServis.SERVICE_KHUSUS;
                        break;
                    default:
                        System.out.println("Pilihan tidak valid, jenis servis akan diatur ke SERVICE_RINGAN.");
                        jenisServis = Servis.JenisServis.SERVICE_RINGAN; 
                        break;
                }

                System.out.println();

                Servis servis = new Servis(tanggalServis, jenisServis, kendaraan);
                
                System.out.println("Pilih komponen yang diganti : ");
                System.out.println("1. Oli");
                System.out.println("2. Filter");
                System.out.println("3. Busi");
                System.out.print("Masukkan jumlah komponen yang ingin diganti (maksimal 3) : ");
                int jumlahKomponen = scanner.nextInt();
                scanner.nextLine();

                for (int k = 0; k < jumlahKomponen; k++) {
                    System.out.print("Pilih komponen yang diganti (1/2/3) : ");
                    int komponenPilihan = scanner.nextInt(); 
                    scanner.nextLine();

                    switch (komponenPilihan) {
                        case 1:
                            servis.tambahKomponen("Oli");
                            break;
                        case 2:
                            servis.tambahKomponen("Filter");
                            break;
                        case 3:
                            servis.tambahKomponen("Busi");
                            break;
                        default:
                            System.out.println("Pilihan tidak valid, tidak ada komponen yang ditambahkan.");
                            k--; //ulang iterasi sampe valid
                            break;
                    }
                }

                // Hitung & + biaya layanan ke pelanggan
                int totalBiaya = servis.hitungTotalBiaya();
                pelanggan.tambahBiayaServis(totalBiaya);
                
                System.out.println();
                servis.cetakDetailServis(); 
            }
        }

        System.out.println("DAFTAR PELANGGAN & KENDARAAN");
        System.out.println();
        for (Pelanggan pelanggan : daftarPelanggan) {
            pelanggan.tampilkanInfoPelanggan(); 
            pelanggan.tampilkanDaftarKendaraan(); 
        }

        System.out.println();
        System.out.println("Terima kasih telah mempercayakan kendaraan Anda kepada kami!");
        System.out.println();

        scanner.close();
    }
}
