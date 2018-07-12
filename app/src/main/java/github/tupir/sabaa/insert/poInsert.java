package github.tupir.sabaa.insert;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import github.tupir.sabaa.AppController;
import github.tupir.sabaa.MainActivity;
import github.tupir.sabaa.POActivity;
import github.tupir.sabaa.R;

import static github.tupir.sabaa.AppController.TAG;

public class poInsert extends AppCompatActivity {
    Button btnSimpan;
    Spinner spinner;
    String inputUrl = "http://<your-url-here>/sabaa/inputPO.php";
    String supplier = "http://<your-url-here>/sabaa/ambilNamaSupplier.php";
    ArrayList<String> Namasupplier;
    ArrayList<String> Idsupplier;
    TextView pojumlah, podate, poharga, poDiskon, poIdmitra, poNamaBarang;
    String idHolder, namaholder,jumlahHolder, hargaHolder, dateHolder, diskonHolder;
    DatePickerDialog datePickerDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insertpo);
        Namasupplier = new ArrayList<>();
        Idsupplier = new ArrayList<>();
        poIdmitra  = (TextView) findViewById(R.id.po_idsupp);
        poNamaBarang = (TextView) findViewById(R.id.po_namabarang);
        pojumlah   = (TextView) findViewById(R.id.po_jumlah);
        poharga    = (TextView) findViewById(R.id.po_harga);
        pojumlah   = (TextView) findViewById(R.id.po_jumlah);
        podate     = (TextView) findViewById(R.id.po_date);
        poDiskon   = (TextView) findViewById(R.id.po_diskon) ;

        spinner    = (Spinner) findViewById(R.id.spinnerSUP);
        loadSupplier(supplier);

        podate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(poInsert.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                podate.setText(year + "-"
                                        + (monthOfYear + 1) + "-" + dayOfMonth);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int i = spinner.getSelectedItemPosition();
                poIdmitra.setText(Idsupplier.get(i));
                poIdmitra.setEnabled(false);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnSimpan = (Button)findViewById(R.id.btn_simpanPO);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetValueFromEditText();
                StringRequest stringRequest = new StringRequest(Request.Method.POST, inputUrl,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String ServerResponse) {
                                // Showing response message coming from server.
                                Toast.makeText(poInsert.this, ServerResponse, Toast.LENGTH_LONG).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError volleyError) {
                                // Showing error message if something goes wrong.
                                Toast.makeText(poInsert.this, volleyError.toString(), Toast.LENGTH_LONG).show();
                                volleyError.getStackTrace();
                            }
                        }) {
                    @Override
                    protected Map<String, String> getParams() {
                        // Creating Map String Params.
                        Map<String, String> params = new HashMap<String, String>();

                        // Adding All values to Params.
                        params.put("idSupplier", idHolder);
                        params.put("namaBarang", namaholder);
                        params.put("tglPO", dateHolder);
                        params.put("jumlahBarang", jumlahHolder);
                        params.put("hargaBarang", hargaHolder);
                        params.put("discount", diskonHolder);
                        return params;
                    }

                };
                // Creating RequestQueue.
                RequestQueue requestQueue = Volley.newRequestQueue(poInsert.this);
                // Adding the StringRequest object into requestQueue.
                requestQueue.add(stringRequest);
                Intent intent = new Intent(poInsert.this, POActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loadSupplier(String url) {
        JsonObjectRequest bmRequest = new JsonObjectRequest(Request.Method.GET, url, null,new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());

                try {
                    JSONArray obj = response.getJSONArray("result");
                    for(int i=0;i< obj.length();i++) {
                        JSONObject json     = obj.getJSONObject(i);
                        String id = json.getString("idSupplier");
                        String nama = json.getString("namaSupplier");
                        Namasupplier.add(nama);
                        Idsupplier.add(id);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    e.getMessage();
                }
                spinner.setAdapter(new ArrayAdapter<String>(poInsert.this, android.R.layout.simple_spinner_dropdown_item, Namasupplier));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
            }
        });
        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(bmRequest);
    }

    public void GetValueFromEditText(){
        idHolder   =  poIdmitra.getText().toString();
        namaholder   =  poNamaBarang.getText().toString();
        dateHolder       =  podate.getText().toString();
        jumlahHolder     =  pojumlah.getText().toString();
        hargaHolder     = poharga.getText().toString();
        diskonHolder       =  poDiskon.getText().toString();
    }

}

