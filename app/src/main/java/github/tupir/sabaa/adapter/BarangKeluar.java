package github.tupir.sabaa.adapter;

public class BarangKeluar {
    private String idBarang, namaBarang, tglBarang ,jumlahBarang, tujuanBarang;

    public BarangKeluar() {
    }

    public BarangKeluar(String idBarang,String namaBarang, String tglBarang, String jumlahBarang, String tujuanBarang) {
        this.namaBarang = namaBarang;
        this.tglBarang = tglBarang;
        this.jumlahBarang = jumlahBarang;
        this.idBarang = idBarang;
        this.tujuanBarang = tujuanBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public String getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }

    public String getTujuanBarang() {
        return tujuanBarang;
    }

    public void setTujuanBarang(String tujuanBarang) {
        this.tujuanBarang = tujuanBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }


    public String getJumlahBarang() {
        return jumlahBarang;
    }

    public void setJumlahBarang(String jumlahBarang ) {
        this.jumlahBarang = jumlahBarang;
    }

    public String getTglBarang() {
        return tglBarang;
    }

    public void setTglBarang(String tglBarang) {
        this.tglBarang = tglBarang;
    }


}

