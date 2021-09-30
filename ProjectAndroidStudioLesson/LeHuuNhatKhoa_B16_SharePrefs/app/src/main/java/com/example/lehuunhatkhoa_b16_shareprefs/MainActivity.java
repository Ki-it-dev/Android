package com.example.lehuunhatkhoa_b16_shareprefs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edta,edtb,edtkq;
    Button btntong,btnclear;
    TextView txtlichsu;
    String lichsu="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edta = findViewById(R.id.edita);
        edtb = findViewById(R.id.editb);
        edtkq = findViewById(R.id.editkq);
        btntong = findViewById(R.id.btntong);
        btnclear =findViewById(R.id.btnclear);
        txtlichsu = findViewById(R.id.txtlichsu);
        //Get data
        SharedPreferences preferences = getSharedPreferences("mysave",MODE_PRIVATE);
        lichsu = preferences.getString("lichsu","");
        txtlichsu.setText(""+lichsu);
        //Update
        btntong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(edta.getText().toString());
                int b = Integer.parseInt(edtb.getText().toString());
                int kq = a + b;
                edtkq.setText(kq+"");
                lichsu += a+ " + "+b+" = "+kq;
                txtlichsu.setText(lichsu);
                lichsu += "\n";
            }
        });
        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lichsu="";
                txtlichsu.setText(lichsu);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences preferences = getSharedPreferences("mysave",MODE_PRIVATE);
        SharedPreferences.Editor myeditor = preferences.edit();
        myeditor.putString("lichsu",lichsu);
        myeditor.commit();
    }
}