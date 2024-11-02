public class Mobil extends Kendaraan {
    private int jumlahPintu;

    // konstruktor
    public Mobil(String nama, String tipe, String nomorPlat, int jumlahPintu) {
        super(nama, tipe, nomorPlat);
        this.jumlahPintu = jumlahPintu;
    }

    // getter n setter
    public int getJumlahPintu() {
        return jumlahPintu;
    }

    public void setJumlahPintu(int jumlahPintu) {
        this.jumlahPintu = jumlahPintu;
    }

    @Override
    public void tampilkanInfoKendaraan() {
        super.tampilkanInfoKendaraan();
        System.out.println("Jumlah Pintu: " + jumlahPintu);
    }
}
