/*
 * *
 *   * Created by Tupir
 *
 */

package github.tupir.sabaa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

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

import github.tupir.sabaa.adapter.AdapaterMasterBarang;
import github.tupir.sabaa.adapter.MasterBarang;
import github.tupir.sabaa.insert.masterbaranginsert;

import static github.tupir.sabaa.AppController.TAG;

public class MasterActivity extends AppCompatActivity {
    private static final String url = "http://<your-url-here>/sabaa/ambilNamaBarang.php";
    private List<MasterBarang> masterList = new ArrayList<MasterBarang>();
    private ListView lv;
    private AdapaterMasterBarang adapterMasterBarang;
    private Button button;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masterbarang);

        lv = (ListView) findViewById(R.id.listMasterBarang);
        masterList = new ArrayList<MasterBarang>();
        adapterMasterBarang = new AdapaterMasterBarang(this, masterList);
        button = (Button) findViewById(R.id.btnInMasterBarang);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MasterActivity.this, masterbaranginsert.class);
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
                        MasterBarang mb = new MasterBarang();
                        mb.setIdBarang(json.getString("idBarang"));
                        mb.setNamaBarang(json.getString("namaBarang"));
                        mb.setStokBarang(json.getString("stokBarang"));
                        //Adding data into array
                        masterList.add(mb);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    e.getMessage();
                }
                adapterMasterBarang.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
            }
        });
        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(bmRequest);
        lv.setAdapter(adapterMasterBarang);
    }
}


