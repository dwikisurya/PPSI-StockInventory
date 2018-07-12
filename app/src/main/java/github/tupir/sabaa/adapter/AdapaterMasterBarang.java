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

public class AdapaterMasterBarang extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<MasterBarang> masterItems;


    public AdapaterMasterBarang(Activity activity, List<MasterBarang> masterItems) {
        this.activity = activity;
        this.masterItems = masterItems;
    }

    @Override
    public int getCount() {
        return masterItems.size();
    }

    @Override
    public Object getItem(int position) {
        return masterItems.get(position);
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
            convertView = inflater.inflate(R.layout.masterbarang_listrow, null);

        TextView idbarang = (TextView) convertView.findViewById(R.id.masterBarang_id);
        TextView namabarang = (TextView) convertView.findViewById(R.id.masterBarang_nama);
        TextView stokbarang = (TextView) convertView.findViewById(R.id.masterBarang_stok);

        // getting movie data for the row
        MasterBarang mb = masterItems.get(position);

        //set barang masuk
        idbarang.setText(mb.getIdBarang());
        namabarang.setText(mb.getNamaBarang());
        stokbarang.setText(mb.getStokBarang());

        return convertView;
    }
}
