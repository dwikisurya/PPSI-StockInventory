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

public class AdapterMB extends BaseAdapter{
    private Activity activity;
    private LayoutInflater inflater;
    private List<MintaBarang> mbItems;


    public AdapterMB(Activity activity, List<MintaBarang> mbItems) {
        this.activity = activity;
        this.mbItems = mbItems;
    }

    @Override
    public int getCount() {
        return mbItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mbItems.get(position);
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
            convertView = inflater.inflate(R.layout.mb_listrow, null);

        TextView namabarang = (TextView) convertView.findViewById(R.id.mb_namaBarang);
        TextView jumlahbarang = (TextView) convertView.findViewById(R.id.mb_jumlahBarang);
        TextView tglbarang = (TextView) convertView.findViewById(R.id.mb_tglBarang);

        // getting movie data for the row
        MintaBarang mb = mbItems.get(position);


        // namaBarang
        namabarang.setText(mb.getNamaBarang());
        // jumlahBarang
        jumlahbarang.setText(mb.getJumlahBarang());
        // tglBarang
        tglbarang.setText(mb.getTglBarang());

        return convertView;
    }
}
