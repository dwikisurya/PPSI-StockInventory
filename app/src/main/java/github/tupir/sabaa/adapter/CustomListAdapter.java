/*
 * *
 *   * Created by Tupir
 *
 */

package github.tupir.sabaa.adapter;

import github.tupir.sabaa.R;

import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Tupir on 9/5/2017.
 */
public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<BarangKeluar> bkItems;


    public CustomListAdapter(Activity activity, List<BarangKeluar> bkItems) {
        this.activity = activity;
        this.bkItems = bkItems;
    }

    @Override
    public int getCount() {
        return bkItems.size();
    }

    @Override
    public Object getItem(int position) {
        return bkItems.get(position);
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
            convertView = inflater.inflate(R.layout.bk_listrow, null);

        TextView namabarang = (TextView) convertView.findViewById(R.id.txtnamabarang);
        TextView jumlahbarang = (TextView) convertView.findViewById(R.id.txtjumlahbarang);
        TextView tglbarang = (TextView) convertView.findViewById(R.id.txttglbarang);

        // getting movie data for the row
        BarangKeluar bk = bkItems.get(position);


        // namaBarang
        namabarang.setText(bk.getNamaBarang());
        // jumlahBarang
        jumlahbarang.setText(bk.getJumlahBarang());
        // tglBarang
        tglbarang.setText(bk.getTglBarang());

        return convertView;
    }
}