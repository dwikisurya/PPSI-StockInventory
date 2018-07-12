package github.tupir.sabaa.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import github.tupir.sabaa.MasterActivity;
import github.tupir.sabaa.POActivity;
import github.tupir.sabaa.R;
import github.tupir.sabaa.StockCardActivity;

public class homeFragment extends Fragment {
    private Button button,button1,button2;
    public static homeFragment newInstance() {
        homeFragment fragment = new homeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        button = (Button)view.findViewById(R.id.btnMasterBarang);
        button2 = (Button) view.findViewById(R.id.btnPurchaseOrder);
        button1 = (Button)view.findViewById(R.id.btnKartuStok);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MasterActivity.class);
                startActivity(intent);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), StockCardActivity.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), POActivity.class);
                startActivity(intent);
            }
        });

    }
}