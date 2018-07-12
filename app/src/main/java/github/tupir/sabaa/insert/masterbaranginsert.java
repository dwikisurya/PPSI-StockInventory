package github.tupir.sabaa.insert;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import github.tupir.sabaa.MainActivity;
import github.tupir.sabaa.MasterActivity;
import github.tupir.sabaa.R;

public class masterbaranginsert extends AppCompatActivity {
    Button btnPost;
    String inputUrl = "http://<your-url-here>/sabaa/insertMasterBarang.php";
    TextView masterID, masterNama, masterStok;
    String idHolder, namaHolder, stokHolder;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insertmasterbarang);

        masterID   = (TextView) findViewById(R.id.inputmaster_id);
        masterNama = (TextView) findViewById(R.id.inputmaster_nama);
        masterStok = (TextView) findViewById(R.id.inputmaster_stok);

        btnPost = (Button)findViewById(R.id.btnSimpanMasterBarang);
        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Calling method to get value from EditText.
                GetValueFromEditText();
                // Creating string request with post method.
                StringRequest stringRequest = new StringRequest(Request.Method.POST, inputUrl,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String ServerResponse) {
                                // Showing response message coming from server.
                                Toast.makeText(masterbaranginsert.this, ServerResponse, Toast.LENGTH_LONG).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError volleyError) {
                                // Showing error message if something goes wrong.
                                Toast.makeText(masterbaranginsert.this, volleyError.toString(), Toast.LENGTH_LONG).show();
                                volleyError.getStackTrace();
                            }
                        }) {
                    @Override
                    protected Map<String, String> getParams() {
                        // Creating Map String Params.
                        Map<String, String> params = new HashMap<String, String>();

                        // Adding All values to Params.
                        params.put("idBarang", idHolder);
                        params.put("namaBarang", namaHolder);
                        params.put("stokBarang", stokHolder);
                        return params;
                    }

                };
                // Creating RequestQueue.
                RequestQueue requestQueue = Volley.newRequestQueue(masterbaranginsert.this);
                // Adding the StringRequest object into requestQueue.
                requestQueue.add(stringRequest);
                Intent intent = new Intent(masterbaranginsert.this, MasterActivity.class);
                startActivity(intent);
            }
        });
    }

    public void GetValueFromEditText(){
        idHolder       =  masterID.getText().toString();
        namaHolder     =  masterNama.getText().toString();
        stokHolder     =  masterStok.getText().toString();
    }
    }

