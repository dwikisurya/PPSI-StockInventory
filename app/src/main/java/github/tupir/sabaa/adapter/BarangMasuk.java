package github.tupir.sabaa.adapter;

public class BarangMasuk {
    private String namaBarang, tglBarang ,jumlahBarang, idBarang, supplierBarang;

    public BarangMasuk() {

    }

    public String getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }

    public String getSupplierBarang() {
        return supplierBarang;
    }

    public void setSupplierBarang(String supplierBarang) {
        this.supplierBarang = supplierBarang;
    }

    public BarangMasuk(String idBarang , String namaBarang, String tglBarang, String jumlahBarang, String supplierBarang) {
        this.namaBarang = namaBarang;
        this.tglBarang = tglBarang;
        this.jumlahBarang = jumlahBarang;
        this.idBarang = idBarang;

        this.supplierBarang = supplierBarang;

    }
    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getTglBarang() {
        return tglBarang;
    }

    public void setTglBarang(String tglBarang) {
        this.tglBarang = tglBarang;
    }

    public String getJumlahBarang() {
        return jumlahBarang;
    }

    public void setJumlahBarang(String jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }
}
