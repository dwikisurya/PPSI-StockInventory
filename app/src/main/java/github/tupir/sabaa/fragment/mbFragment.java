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
import github.tupir.sabaa.R;
import github.tupir.sabaa.adapter.AdapterBM;
import github.tupir.sabaa.adapter.AdapterMB;
import github.tupir.sabaa.adapter.BarangMasuk;
import github.tupir.sabaa.adapter.MintaBarang;
import github.tupir.sabaa.insert.mbInsert;

import static github.tupir.sabaa.AppController.TAG;

public class mbFragment extends Fragment{
    private Button button1;
    private static final String url = "http://192.168.43.20/sabaa/mintaBarang.php";
    private List<MintaBarang> mbList = new ArrayList<MintaBarang>();
    private ListView lv;
    private AdapterMB adapter;

    public static mbFragment newInstance() {
        mbFragment fragment = new mbFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_mb, container, false);
        rootView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        lv = (ListView) rootView.findViewById(R.id.listMB);

        mbList = new ArrayList<MintaBarang>();
        adapter = new AdapterMB(getActivity(), mbList);
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
                        MintaBarang mb = new MintaBarang();
                        mb.setPemintaBarang(json.getString("pemintaMB"));
                        mb.setNamaBarang(json.getString("barangMB"));
                        mb.setJumlahBarang(json.getString("jumlahMB"));
                        mb.setTglBarang(json.getString("tglMB"));

                        //Adding data into array
                        mbList.add(mb);
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

        button1 = (Button)view.findViewById(R.id.btnFragmentMB);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), mbInsert.class);
                startActivity(intent);
            }
        });
    }
}