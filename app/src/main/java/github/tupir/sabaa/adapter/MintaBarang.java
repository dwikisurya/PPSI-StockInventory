/*
 * *
 *   * Created by Tupir
 *
 */

package github.tupir.sabaa.adapter;

public class MintaBarang {
    private String pemintaBarang,namaBarang, tglBarang ,jumlahBarang;

    public MintaBarang(){

    }

    public MintaBarang(String pemintaBarang,String namaBarang, String tglBarang, String jumlahBarang) {
        this.pemintaBarang = pemintaBarang;
        this.namaBarang = namaBarang;
        this.tglBarang = tglBarang;
        this.jumlahBarang = jumlahBarang;
    }

    public String getPemintaBarang() {
        return pemintaBarang;
    }

    public void setPemintaBarang(String pemintaBarang) {
        this.pemintaBarang = pemintaBarang;
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
