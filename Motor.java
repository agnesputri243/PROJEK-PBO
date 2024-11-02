public class Motor extends Kendaraan {
    private boolean memilikiBagasi;

    // konstruktor
    public Motor(String nama, String tipe, String nomorPlat, boolean memilikiBagasi) {
        super(nama, tipe, nomorPlat);
        this.memilikiBagasi = memilikiBagasi;
    }

    // getter n setter
    public boolean isMemilikiBagasi() {
        return memilikiBagasi;
    }

    public void setMemilikiBagasi(boolean memilikiBagasi) {
        this.memilikiBagasi = memilikiBagasi;
    }

    @Override
    public void tampilkanInfoKendaraan() {
        super.tampilkanInfoKendaraan();
        System.out.println("Memiliki Bagasi: " + (memilikiBagasi ? "Ya" : "Tidak"));
    }
}
