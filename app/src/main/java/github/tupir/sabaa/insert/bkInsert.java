package github.tupir.sabaa.insert;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import github.tupir.sabaa.MainActivity;
import github.tupir.sabaa.R;

public class bkInsert extends AppCompatActivity {
    Button btnsimpanBK;
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insertbk);


        btnsimpanBK = (Button)findViewById(R.id.btnSimpanBK);
        btnsimpanBK.setOnClickListener(new View.OnClickListener() {
           @Override
          public void onClick(View v) {
              Intent intent = new Intent(bkInsert.this, MainActivity.class);
            startActivity(intent);
            }
       });
    }
}
