package github.tupir.sabaa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

import github.tupir.sabaa.adapter.AdapterKS;
import github.tupir.sabaa.adapter.AdapterStockCard;
import github.tupir.sabaa.adapter.KartuStok;
import github.tupir.sabaa.insert.masterbaranginsert;
import github.tupir.sabaa.insert.poInsert;


import static github.tupir.sabaa.AppController.TAG;

public class POActivity extends AppCompatActivity{
    private Button buttonPO;
    private static final String url = "http://192.168.43.20/sabaa/purchaseOrder.php";
    private List<KartuStok> ksList = new ArrayList<KartuStok>();
    private ListView lv;
    private AdapterKS adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchaseorder);

        lv = (ListView) findViewById(R.id.listPurchaseOrder);
        ksList = new ArrayList<KartuStok>();
        adapter = new AdapterKS(POActivity.this, ksList);

        buttonPO = (Button) findViewById(R.id.btnInPO);
        buttonPO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(POActivity.this, poInsert.class);
                startActivity(intent);
            }
        });

        //Create JsonObjectRequest
        JsonObjectRequest bmRequest = new JsonObjectRequest(Request.Method.GET, url, null,new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());

                try {
                    JSONArray obj = response.getJSONArray("result");
                    for(int i=0;i< obj.length();i++) {
                        JSONObject json     = obj.getJSONObject(i);
                        KartuStok ks = new KartuStok();
                        ks.setIdPO(json.getString("idPO"));
                        ks.setNamaBarang(json.getString("namaBarang"));
                        ks.setJumlahBarang(json.getString("jumlahBarang"));
                        ks.setHargaBarang(json.getString("hargaBarang"));
                        ks.setDiscountPO(json.getString("discountBarang"));
                        ks.setTotalHarga(json.getString("grandTotal"));
                        //Adding data into array
                        ksList.add(ks);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    e.getMessage();
                }
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
            }
        });
        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(bmRequest);
        lv.setAdapter(adapter);
    }
}