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

        TextView idbarang = (TextView) convertView.findViewById(R.id.BM_SET_ID);
        TextView namabarang = (TextView) convertView.findViewById(R.id.BM_SET_NAMA);
        TextView jumlahbarang = (TextView) convertView.findViewById(R.id.BM_SET_JUMLAH);
        TextView tglbarang = (TextView) convertView.findViewById(R.id.BM_SET_TGL);
        TextView supplier = (TextView) convertView.findViewById(R.id.BM_SET_TUJUAN);

        // getting movie data for the row
        BarangMasuk bm = bmItems.get(position);

        //set barang masuk
        idbarang.setText(bm.getIdBarang());
        namabarang.setText(bm.getNamaBarang());
        jumlahbarang.setText(bm.getJumlahBarang());
        tglbarang.setText(bm.getTglBarang());
        supplier.setText(bm.getSupplierBarang());
        return convertView;
    }
}

