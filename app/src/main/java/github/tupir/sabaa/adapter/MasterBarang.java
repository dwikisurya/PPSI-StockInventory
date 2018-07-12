/*
 * *
 *   * Created by Tupir
 *
 */

package github.tupir.sabaa.adapter;

public class MasterBarang {
    private String idBarang, namaBarang,stokBarang;

    public MasterBarang() {

    }

    public MasterBarang(String idBarang , String namaBarang, String stokbarang) {
        this.namaBarang = namaBarang;
        this.idBarang = idBarang;
        this.stokBarang = stokbarang;
        this.idBarang = idBarang;
    }

    public String getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getStokBarang() {
        return stokBarang;
    }

    public void setStokBarang(String stokBarang) {
        this.stokBarang = stokBarang;
    }
}
