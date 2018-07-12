/*
 * *
 *   * Created by Tupir
 *
 */

package github.tupir.sabaa.adapter;

public class KartuStok {
    private String idPO, namaBarang;
    private String jumlahBarang;
    private String hargaBarang, discountPO, totalHarga;

    public KartuStok(){

    }

    public KartuStok(String idPO, String namaBarang, String jumlahBarang, String hargaBarang, String discountPO, String totalHarga){
       this.idPO = idPO;
       this.namaBarang = namaBarang;
       this.jumlahBarang = jumlahBarang;
       this.hargaBarang = hargaBarang;
       this.discountPO = discountPO;
       this.totalHarga = totalHarga;
    }

    public String getIdPO() {
        return idPO;
    }

    public void setIdPO(String idPO) {
        this.idPO = idPO;
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

    public String getHargaBarang() {
        return hargaBarang;
    }

    public void setHargaBarang(String hargaBarang) {
        this.hargaBarang = hargaBarang;
    }

    public String getDiscountPO() {
        return discountPO;
    }

    public void setDiscountPO(String discountPO) {
        this.discountPO = discountPO;
    }

    public String getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(String totalHarga) {
        this.totalHarga = totalHarga;
    }
}
