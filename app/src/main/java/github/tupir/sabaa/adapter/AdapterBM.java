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

public class AdapterBM extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<BarangMasuk> bmItems;


    public AdapterBM(Activity activity, List<BarangMasuk> bmItems) {
        this.activity = activity;
        this.bmItems = bmItems;
    }

    @Override
    public int getCount() {
        return bmItems.size();
    }

    @Override
    public Object getItem(int position) {
        return bmItems.get(position);
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
            convertView = inflater.inflate(R.layout.bm_listrow, null);

        TextView namabarang = (TextView) convertView.findViewById(R.id.bm_namaBarang);
        TextView jumlahbarang = (TextView) convertView.findViewById(R.id.bm_jumlahBarang);
        TextView tglbarang = (TextView) convertView.findViewById(R.id.bm_tglBarang);

        // getting movie data for the row
        BarangMasuk bm = bmItems.get(position);

        // namaBarang
        namabarang.setText(bm.getNamaBarang());
        // jumlahBarang
        jumlahbarang.setText(bm.getJumlahBarang());
        // tglBarang
        tglbarang.setText(bm.getTglBarang());

        return convertView;
    }
}

