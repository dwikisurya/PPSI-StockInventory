package github.tupir.sabaa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import github.tupir.sabaa.adapter.AdapterStockCard;
import github.tupir.sabaa.adapter.stokCard;

import static github.tupir.sabaa.AppController.TAG;

public class StockCardActivity extends AppCompatActivity {
    private static final String url = "http://192.168.43.20/sabaa/union.php";
    private List<stokCard> stokList = new ArrayList<stokCard>();
    private ListView lv;
    private AdapterStockCard adapterStockCard;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kartustok);

        lv = (ListView) findViewById(R.id.listKartuStok);
        stokList = new ArrayList<stokCard>();
        adapterStockCard = new AdapterStockCard(this, stokList);


        //Create JsonObjectRequest
        JsonObjectRequest bmRequest = new JsonObjectRequest(Request.Method.GET, url, null,new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());

                try {
                    JSONArray obj = response.getJSONArray("result");
                    for(int i=0;i< obj.length();i++) {
                        JSONObject json     = obj.getJSONObject(i);
                        stokCard sc = new stokCard();
                        sc.setNamaBarang(json.getString("namaBarang"));
                        sc.setJumlahBarang(json.getString("jumlahBarang"));
                        sc.setTglKeluar(json.getString("tglKeluar"));
                        sc.setTglMasuk(json.getString("tglMasuk"));
                        sc.setMitra(json.getString("tujuanBarang"));
                        sc.setSupplier(json.getString("supplier"));
                        //Adding data into array
                        stokList.add(sc);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    e.getMessage();
                }
                adapterStockCard.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
            }
        });
        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(bmRequest);
        lv.setAdapter(adapterStockCard);
    }
}

