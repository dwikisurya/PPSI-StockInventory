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

        //TextView bm_namabarang = (TextView) convertView.findViewById(R.id.mb_namaBarang);
        //TextView bm_jumlahbarang  = (TextView) convertView.findViewById(R.id.mb_jumlahBarang);
        //TextView bm_tglbarang  = (TextView) convertView.findViewById(R.id.mb_tglBarang);
        // TextView bm_supplier = (TextView) convertView.findViewById(R.id.);

        // TextView bk_namabarang = (TextView) convertView.findViewById(R.id.mb_namaBarang);
        //TextView bk_jumlahbarang  = (TextView) convertView.findViewById(R.id.mb_jumlahBarang);
        //TextView bk_tglbarang  = (TextView) convertView.findViewById(R.id.mb_tglBarang);
        //TextView bk_tujuan= (TextView) convertView.findViewById(R.id.);

        // getting movie data for the row
        KartuStok ks = ksItems.get(position);

        //bm_namabarang.setText(ks.getBm_namabarang());
        //bm_jumlahbarang.setText(ks.getBm_jumlahBarang());
        //bm_tglbarang.setText(ks.getBm_tglBarang());
        //bm_supplier.setText(ks.getBm_supplier());

        //bk_namabarang.setText(ks.getBk_namabarang());
        //bk_jumlahbarang.setText(ks.getBk_jumlahBarang());
        //bk_tglbarang.setText(ks.getBk_tglBarang());
        //bk_tujuan.setText(ks.getBk_tujuanBarang());
        return convertView;
    }
}
