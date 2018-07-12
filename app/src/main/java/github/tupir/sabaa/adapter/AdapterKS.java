/*
 * *
 *   * Created by Tupir
 *
 */

package github.tupir.sabaa.adapter;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import github.tupir.sabaa.R;

public class AdapterKS extends BaseAdapter{
    private Activity activity;
    private LayoutInflater inflater;
    private List<KartuStok> ksItems;

    public AdapterKS(Activity activity, List<KartuStok> ksItems) {
        this.activity = activity;
        this.ksItems= ksItems;
    }

    @Override
    public int getCount() {
        return ksItems.size();
    }

    @Override
    public Object getItem(int position) {
        return ksItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.ks_listrow, null);

        TextView ks_id = (TextView) convertView.findViewById(R.id.ks_setIDks);
        TextView ks_nama = (TextView) convertView.findViewById(R.id.ks_setNamaBarang);
        TextView ks_jumlah = (TextView) convertView.findViewById(R.id.ks_setJumlahBarang);
        TextView ks_harga = (TextView) convertView.findViewById(R.id.ks_setHargaBarang);
        TextView ks_discount = (TextView) convertView.findViewById(R.id.ks_setDiscountBarang);
        TextView ks_grandtot = (TextView) convertView.findViewById(R.id.ks_setHargaTotal);

        // getting movie data for the row
        KartuStok ks = ksItems.get(position);
        ks_id.setText(ks.getIdPO());
        ks_nama.setText(ks.getNamaBarang());
        ks_jumlah.setText(ks.getJumlahBarang());
        ks_harga.setText(ks.getHargaBarang());
        ks_discount.setText(ks.getDiscountPO());
        ks_grandtot.setText(ks.getTotalHarga());
      ;
        return convertView;
    }
}
