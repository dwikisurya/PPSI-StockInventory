package github.tupir.sabaa.insert;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import github.tupir.sabaa.AppController;
import github.tupir.sabaa.MainActivity;
import github.tupir.sabaa.R;

import static github.tupir.sabaa.AppController.TAG;

public class bkInsert extends AppCompatActivity {
    Button btnsimpanBK;
    Spinner spinner;
    DatePicker datePicker;
    String url = "http://192.168.43.20/sabaa/ambilNama.php";
    ArrayList<String> Namabarang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insertbk);
        Namabarang = new ArrayList<>();
        spinner = (Spinner) findViewById(R.id.spinner);

        loadSpinnerData(url);

        btnsimpanBK = (Button) findViewById(R.id.btnSimpanBK);
        btnsimpanBK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bkInsert.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loadSpinnerData(String url) {
        JsonObjectRequest bkRequest = new JsonObjectRequest(Request.Method.GET, url, null,new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());

                try {
                    JSONArray obj = response.getJSONArray("result");
                    for(int i=0;i< obj.length();i++) {
                        JSONObject json     = obj.getJSONObject(i);
                        String nama = json.getString("namaBarang");
                        Namabarang.add(nama);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    e.getMessage();
                }
                spinner.setAdapter(new ArrayAdapter<String>(bkInsert.this, android.R.layout.simple_spinner_dropdown_item, Namabarang));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
            }
        });
        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(bkRequest);
    }
}

