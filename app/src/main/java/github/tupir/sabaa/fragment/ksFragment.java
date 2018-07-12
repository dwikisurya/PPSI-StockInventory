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

import github.tupir.sabaa.AppController;
import github.tupir.sabaa.MasterActivity;
import github.tupir.sabaa.R;
import github.tupir.sabaa.adapter.AdapterKS;
import github.tupir.sabaa.adapter.KartuStok;
import github.tupir.sabaa.insert.masterbaranginsert;

import static github.tupir.sabaa.AppController.TAG;


public class ksFragment extends Fragment {
    private Button button1;
    private static final String url = "http://<your-url-here>/sabaa/purchaseOrder.php";
    private List<KartuStok> ksList = new ArrayList<KartuStok>();
    private ListView lv;
    private AdapterKS adapter;

    public static ksFragment newInstance() {
        ksFragment fragment = new ksFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_ks, container, false);
        rootView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        lv = (ListView) rootView.findViewById(R.id.listKS);

        ksList = new ArrayList<KartuStok>();
        adapter = new AdapterKS(getActivity(), ksList);
        lv.setAdapter(adapter);

        //Create JsonObjectRequest
        JsonObjectRequest mbRequest = new JsonObjectRequest(Request.Method.GET, url, null,new Response.Listener<JSONObject>(){
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
                // notifying list adapter about data changes
                // so that it renders the list view with updated data
                adapter.notifyDataSetChanged();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
            }
        });
        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(mbRequest);
        return rootView;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

            }
}

