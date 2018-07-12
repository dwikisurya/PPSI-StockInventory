package github.tupir.sabaa;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import github.tupir.sabaa.fragment.bkFragment;
import github.tupir.sabaa.fragment.bmFragment;
import github.tupir.sabaa.fragment.homeFragment;
import github.tupir.sabaa.fragment.ksFragment;
import github.tupir.sabaa.fragment.mbFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActionBar toolbar;
    String uname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = getSupportActionBar();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Intent i =getIntent();
        uname = i.getStringExtra(uname);

        toolbar.setTitle("Shop");
        loadFragment(new homeFragment());
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    toolbar.setTitle("Home");
                    fragment = homeFragment.newInstance();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_barangkeluar:
                    toolbar.setTitle("Barang Keluar");
                    fragment = bkFragment.newInstance();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_barangmasuk:
                    toolbar.setTitle("Barang Masuk");
                    fragment = bmFragment.newInstance();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_mintabarang:
                    toolbar.setTitle("Minta Barang");
                    fragment = mbFragment.newInstance();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
    }

    public void loadInterstitial() {
    }

    public void showInterstitial() {
    }
}