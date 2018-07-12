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

public class AdapterStockCard extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<stokCard> stockItems;

    public AdapterStockCard(Activity activity, List<stokCard> stockItems) {
        this.activity = activity;
        this.stockItems = stockItems;
    }
    @Override
    public int getCount() {
        return stockItems.size();
    }

    @Override
    public Object getItem(int position) {
        return stockItems.get(position);
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
            convertView = inflater.inflate(R.layout.kartustok_listrow, null);

        TextView namabarang = (TextView) convertView.findViewById(R.id.ks_namaBarang);
        TextView jumlah = (TextView) convertView.findViewById(R.id.ks_jumlahBarang);
        TextView tglKeluar = (TextView) convertView.findViewById(R.id.ks_tglKeluar);
        TextView tglMasuk = (TextView) convertView.findViewById(R.id.ks_tglMasuk);
        TextView mitra = (TextView) convertView.findViewById(R.id.ks_tujuan);
        TextView supplier = (TextView) convertView.findViewById(R.id.ks_supplier);

        // getting movie data for the row
        stokCard sc = stockItems.get(position);

        //set barang masuk
        namabarang.setText(sc.getNamaBarang());
        jumlah.setText(sc.getJumlahBarang());
        tglKeluar.setText(sc.getTglKeluar());
        tglMasuk.setText(sc.getTglMasuk());
        mitra.setText(sc.getMitra());
        supplier.setText(sc.getSupplier());


        return convertView;
    }
}

