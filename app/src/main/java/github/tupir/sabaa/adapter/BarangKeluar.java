package github.tupir.sabaa.adapter;

import java.util.ArrayList;

public class BarangKeluar {
    private String namaBarang, tglBarang ,jumlahBarang;

    public BarangKeluar() {
    }

    public BarangKeluar(String namaBarang, String tglBarang, String jumlahBarang) {
        this.namaBarang = namaBarang;
        this.tglBarang = tglBarang;
        this.jumlahBarang = jumlahBarang;

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

