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
import github.tupir.sabaa.R;

import static github.tupir.sabaa.AppController.TAG;

public class bkInsert extends AppCompatActivity {
    Button btnsimpanBK;
    Spinner spinner;
    String url = "http://192.168.43.20/sabaa/ambilNamaBarang.php";
    String inputUrl = "http://192.168.43.20/sabaa/insertBarangKeluar.php";
    ArrayList<String> Namabarang;
    ArrayList<String> Idbarang;
    TextView err,bktujuan, bkjumlah, bkdate;
    String tujuanHolder, jumlahHolder, idbarangHolder, namaHolder, dateHolder;
    DatePickerDialog datePickerDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insertbk);
        Namabarang = new ArrayList<>();
        Idbarang = new ArrayList<>();
        err = (TextView) findViewById(R.id.bkidbarang);
        bktujuan = (TextView) findViewById(R.id.inputBK_Tujuan);
        bkjumlah = (TextView) findViewById(R.id.inputBK_Jumlah);
        bkdate = (TextView) findViewById(R.id.inputBK_Date);
        spinner = (Spinner) findViewById(R.id.spinner);
        loadSpinnerData(url);

        bkdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(bkInsert.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                bkdate.setText(year + "-"
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
                err.setText(Idbarang.get(i));
                err.setEnabled(false);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnsimpanBK = (Button) findViewById(R.id.btnSimpanBK);

        btnsimpanBK.setOnClickListener(new View.OnClickListener() {
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
                                Toast.makeText(bkInsert.this, ServerResponse, Toast.LENGTH_LONG).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError volleyError) {
                                // Showing error message if something goes wrong.
                                Toast.makeText(bkInsert.this, volleyError.toString(), Toast.LENGTH_LONG).show();
                                volleyError.getStackTrace();
                            }
                        }) {
                    @Override
                    protected Map<String, String> getParams() {
                        // Creating Map String Params.
                        Map<String, String> params = new HashMap<String, String>();

                        // Adding All values to Params.
                        params.put("idBarang", idbarangHolder);
                        params.put("namaBarang", namaHolder);
                        params.put("jumlahBarang", jumlahHolder);
                        params.put("tglKeluar", dateHolder);
                        params.put("tujuanBarang", tujuanHolder);

                        return params;
                    }

                };
                // Creating RequestQueue.
                RequestQueue requestQueue = Volley.newRequestQueue(bkInsert.this);
                // Adding the StringRequest object into requestQueue.
                requestQueue.add(stringRequest);
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
                        String id = json.getString("idBarang");
                        String nama = json.getString("namaBarang");
                        Namabarang.add(nama);
                        Idbarang.add(id);
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

    public void GetValueFromEditText(){
        tujuanHolder   =  bktujuan.getText().toString();
        jumlahHolder   =  bkjumlah.getText().toString();
        namaHolder     =  spinner.getSelectedItem().toString();
        idbarangHolder =  err.getText().toString();
        dateHolder     =  bkdate.getText().toString();
    }
}

