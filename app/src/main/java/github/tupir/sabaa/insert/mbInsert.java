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
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import github.tupir.sabaa.AppController;
import github.tupir.sabaa.MainActivity;
import github.tupir.sabaa.R;

import static github.tupir.sabaa.AppController.TAG;


public class mbInsert extends AppCompatActivity {
    Button btnSimpan;
    Spinner spinner, spinner1;
    String inputUrl = "http://<your-url-here>/sabaa/inputMintaBarang.php";
    String namaBarang = "http://<your-url-here>/sabaa/ambilNamaBarang.php";
    String supplier = "http://<your-url-here>/sabaa/ambilNamaMitra.php";
    ArrayList<String> Namabarang;
    ArrayList<String> Namasupplier;
    ArrayList<String> Idbarang;
    ArrayList<String> Idmitra;
    TextView bmjumlah, bmdate, bmPeminta, bmId,bmidMit;
    String namamitraHolder, pemintaHolder, barangHolder, jumlahHolder,dateHolder, idBarangholder, idMitraHolder;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insertmb);
        Namabarang = new ArrayList<>();
        Namasupplier = new ArrayList<>();
        Idbarang= new ArrayList<>();
        Idmitra = new ArrayList<>();
        bmId       = (TextView) findViewById(R.id.mb_idbarang);
        bmidMit    = (TextView) findViewById(R.id.mb_idmitra);
        bmjumlah   = (TextView) findViewById(R.id.inputMB_Jumlah);
        bmdate     = (TextView) findViewById(R.id.inputMB_Date);
        bmPeminta  = (TextView) findViewById(R.id.inputMB_Peminta) ;

        spinner    = (Spinner) findViewById(R.id.spinnerMB);
        spinner1   = (Spinner) findViewById(R.id.spinnerMitra);
        loadNamaBarang(namaBarang);
        loadSupplier(supplier);

        bmdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(mbInsert.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                bmdate.setText(year + "-"
                                        + (monthOfYear + 1) + "-" + dayOfMonth);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int i = spinner1.getSelectedItemPosition();
                bmidMit.setText(Idmitra.get(i));
                bmidMit.setEnabled(false);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int i = spinner.getSelectedItemPosition();
                bmId.setText(Idbarang.get(i));
                bmId.setEnabled(false);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        btnSimpan = (Button)findViewById(R.id.btnSimpanMB);
       btnSimpan.setOnClickListener(new View.OnClickListener() {
    @Override
      public void onClick(View v) {
        GetValueFromEditText();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, inputUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String ServerResponse) {
                        // Showing response message coming from server.
                        Toast.makeText(mbInsert.this, ServerResponse, Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        // Showing error message if something goes wrong.
                        Toast.makeText(mbInsert.this, volleyError.toString(), Toast.LENGTH_LONG).show();
                        volleyError.getStackTrace();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                // Creating Map String Params.
                Map<String, String> params = new HashMap<String, String>();

                // Adding All values to Params.
                params.put("idMitra", idMitraHolder);
                params.put("idBarang", idBarangholder);
                params.put("pemintaMB", pemintaHolder);
                params.put("barangMB", barangHolder);
                params.put("jumlahMB", jumlahHolder);
                params.put("tglMB", dateHolder);
                return params;
            }

        };
        // Creating RequestQueue.
        RequestQueue requestQueue = Volley.newRequestQueue(mbInsert.this);
        // Adding the StringRequest object into requestQueue.
        requestQueue.add(stringRequest);
            Intent intent = new Intent(mbInsert.this, MainActivity.class);
              startActivity(intent);
    }
});
        }
    private void loadNamaBarang(String url) {
        JsonObjectRequest bkRequest = new JsonObjectRequest(Request.Method.GET, url, null,new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());

                try {
                    JSONArray obj = response.getJSONArray("result");
                    for(int i=0;i< obj.length();i++) {
                        JSONObject json     = obj.getJSONObject(i);
                        String id = json.getString("idBarang");
                        String nama = json.getString("namaBarang");
                        Namabarang.add(nama);
                        Idbarang.add(id);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    e.getMessage();
                }
                spinner.setAdapter(new ArrayAdapter<String>(mbInsert.this, android.R.layout.simple_spinner_dropdown_item, Namabarang));
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

    private void loadSupplier(String url) {
        JsonObjectRequest bmRequest = new JsonObjectRequest(Request.Method.GET, url, null,new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());

                try {
                    JSONArray obj = response.getJSONArray("result");
                    for(int i=0;i< obj.length();i++) {
                        JSONObject json     = obj.getJSONObject(i);
                        String id = json.getString("idMitra");
                        String nama = json.getString("namaMitra");
                        Namasupplier.add(nama);
                        Idmitra.add(id);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    e.getMessage();
                }
                spinner1.setAdapter(new ArrayAdapter<String>(mbInsert.this, android.R.layout.simple_spinner_dropdown_item, Namasupplier));
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
        idBarangholder   =  bmId.getText().toString();
        idMitraHolder   = bmidMit.getText().toString();
        barangHolder     =  spinner.getSelectedItem().toString();
        namamitraHolder   =  spinner1.getSelectedItem().toString();
        pemintaHolder    =  bmPeminta.getText().toString();
        jumlahHolder     =  bmjumlah.getText().toString();
        dateHolder       =  bmdate.getText().toString();
    }

}
