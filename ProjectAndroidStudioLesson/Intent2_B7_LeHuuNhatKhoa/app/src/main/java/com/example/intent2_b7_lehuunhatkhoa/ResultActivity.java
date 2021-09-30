package com.example.intent2_b7_lehuunhatkhoa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ResultActivity extends AppCompatActivity {
    TextView txtkq;
    Button btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        txtkq = findViewById(R.id.txtKq);
        btnback = findViewById(R.id.btnBack);
        Intent callback = getIntent();
        Bundle backagecaller1 = callback.getBundleExtra("mybackage");
        int a = backagecaller1.getInt("soa");
        int b = backagecaller1.getInt("sob");
        String kq="";
        if(a==0 && b==0){
            kq="Vô số nghiệm";
        }else if(a==0 && b!=0){
            kq="Vô nghiệm";
        }else{
            DecimalFormat dcf = new DecimalFormat("#.00");
            kq=dcf.format(-b*1.0/a);
        }
        txtkq.setText(kq);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}