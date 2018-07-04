/*
 * *
 *   * Created by Tupir
 *
 */

package github.tupir.sabaa.adapter;

public class KartuStok {
    private String bm_namabarang, bm_tglBarang , bm_jumlahBarang, bm_supplier;
    private String bk_namabarang, bk_tglBarang, bk_jumlahBarang, bk_tujuanBarang;

    public String getBm_namabarang() {
        return bm_namabarang;
    }

    public void setBm_namabarang(String bm_namabarang) {
        this.bm_namabarang = bm_namabarang;
    }

    public String getBm_tglBarang() {
        return bm_tglBarang;
    }

    public void setBm_tglBarang(String bm_tglBarang) {
        this.bm_tglBarang = bm_tglBarang;
    }

    public String getBm_jumlahBarang() {
        return bm_jumlahBarang;
    }

    public void setBm_jumlahBarang(String bm_jumlahBarang) {
        this.bm_jumlahBarang = bm_jumlahBarang;
    }

    public String getBm_supplier() {
        return bm_supplier;
    }

    public void setBm_supplier(String bm_supplier) {
        this.bm_supplier = bm_supplier;
    }

    public String getBk_namabarang() {
        return bk_namabarang;
    }

    public void setBk_namabarang(String bk_namabarang) {
        this.bk_namabarang = bk_namabarang;
    }

    public String getBk_tglBarang() {
        return bk_tglBarang;
    }

    public void setBk_tglBarang(String bk_tglBarang) {
        this.bk_tglBarang = bk_tglBarang;
    }

    public String getBk_jumlahBarang() {
        return bk_jumlahBarang;
    }

    public void setBk_jumlahBarang(String bk_jumlahBarang) {
        this.bk_jumlahBarang = bk_jumlahBarang;
    }

    public String getBk_tujuanBarang() {
        return bk_tujuanBarang;
    }

    public void setBk_tujuanBarang(String bk_tujuanBarang) {
        this.bk_tujuanBarang = bk_tujuanBarang;
    }

    public KartuStok(String bm_namabarang, String bm_tglBarang, String bm_jumlahBarang, String bm_supplier, String bk_namabarang, String bk_tglBarang, String bk_jumlahBarang, String bk_tujuanBarang){
        this.bm_namabarang = bm_namabarang;
        this.bm_tglBarang = bm_tglBarang;
        this.bm_jumlahBarang = bm_jumlahBarang;
        this.bm_supplier = bm_supplier;
        this.bk_namabarang = bk_namabarang;
        this.bk_tglBarang = bk_tglBarang;
        this.bk_jumlahBarang = bk_jumlahBarang;
        this.bk_tujuanBarang = bk_tujuanBarang;
    }


}
