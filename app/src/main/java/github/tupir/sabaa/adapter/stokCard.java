package github.tupir.sabaa.adapter;

public class stokCard {
    private String namaBarang, jumlahBarang,tglMasuk, tglKeluar, mitra, supplier ;

    public stokCard() {

    }

    public stokCard(String namaBarang, String jumlahBarang, String tglMasuk, String tglKeluar, String mitra, String supplier) {
        this.namaBarang = namaBarang;
        this.jumlahBarang = jumlahBarang;
        this.tglMasuk = tglKeluar;
        this.mitra   = mitra;
        this.supplier = supplier;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getJumlahBarang() {
        return jumlahBarang;
    }

    public void setJumlahBarang(String jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }

    public String getTglMasuk() {
        return tglMasuk;
    }

    public void setTglMasuk(String tglMasuk) {
        this.tglMasuk = tglMasuk;
    }

    public String getTglKeluar() {
        return tglKeluar;
    }

    public void setTglKeluar(String tglKeluar) {
        this.tglKeluar = tglKeluar;
    }

    public String getMitra() {
        return mitra;
    }

    public void setMitra(String mitra) {
        this.mitra = mitra;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
}
