package github.tupir.sabaa.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.view.ViewGroup.LayoutParams;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;

import com.android.volley.toolbox.JsonObjectRequest;

import java.util.ArrayList;
import java.util.List;

import github.tupir.sabaa.AppController;
import github.tupir.sabaa.R;
import github.tupir.sabaa.adapter.AdapterBM;
import github.tupir.sabaa.adapter.AdapterMB;
import github.tupir.sabaa.adapter.BarangMasuk;
import github.tupir.sabaa.insert.bmInsert;

import static github.tupir.sabaa.AppController.TAG;

public class bmFragment extends Fragment {
    private Button button1;
    private static final String url = "http://192.168.43.20/sabaa/barangMasuk.php";
    private List<BarangMasuk> bmList = new ArrayList<BarangMasuk>();
    private ListView lv;
    private AdapterBM adapterBM;

    public static bmFragment newInstance() {
        bmFragment fragment = new bmFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_bm, container, false);
        rootView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

        lv = (ListView) rootView.findViewById(R.id.listBM);

        bmList = new ArrayList<BarangMasuk>();
        adapterBM = new AdapterBM(getActivity(), bmList);
        lv.setAdapter(adapterBM);

        //Create JsonObjectRequest
        JsonObjectRequest bmRequest = new JsonObjectRequest(Request.Method.GET, url, null,new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());

                try {
                    JSONArray obj = response.getJSONArray("result");
                    for(int i=0;i< obj.length();i++) {
                        JSONObject json     = obj.getJSONObject(i);
                        BarangMasuk bm = new BarangMasuk();
                        bm.setIdBarang(json.getString("idBM"));
                        bm.setNamaBarang(json.getString("namaBarang"));
                        bm.setJumlahBarang(json.getString("jumlahBarang"));
                        bm.setTglBarang(json.getString("tglMasuk"));
                        bm.setSupplierBarang(json.getString("supplier"));

                        //Adding data into array
                        bmList.add(bm);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    e.getMessage();
                }
                // notifying list adapter about data changes
                // so that it renders the list view with updated data
                adapterBM.notifyDataSetChanged();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
            }
        });
        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(bmRequest);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        button1 = (Button)view.findViewById(R.id.btnFragmentBM);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), bmInsert.class);
                startActivity(intent);
            }
        });
    }
    }
