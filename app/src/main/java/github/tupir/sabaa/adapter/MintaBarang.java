/*
 * *
 *   * Created by Tupir
 *
 */

package github.tupir.sabaa.adapter;

public class MintaBarang {
    private String namaBarang, tglBarang ,jumlahBarang;

    public MintaBarang(){

    }

    public MintaBarang(String namaBarang, String tglBarang, String jumlahBarang) {
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
