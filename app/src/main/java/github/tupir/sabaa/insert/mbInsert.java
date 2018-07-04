package github.tupir.sabaa.insert;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import github.tupir.sabaa.MainActivity;
import github.tupir.sabaa.R;


public class mbInsert extends AppCompatActivity {

    Button btnsimpan;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insertmb);

       btnsimpan = (Button)findViewById(R.id.btnSimpanMB);
       btnsimpan.setOnClickListener(new View.OnClickListener() {
    @Override
      public void onClick(View v) {
            Intent intent = new Intent(mbInsert.this, MainActivity.class);
              startActivity(intent);
    }
});
        }
}