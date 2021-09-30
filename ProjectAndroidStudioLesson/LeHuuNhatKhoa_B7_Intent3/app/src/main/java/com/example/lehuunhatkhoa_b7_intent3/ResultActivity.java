package com.example.lehuunhatkhoa_b7_intent3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.prefs.InvalidPreferencesFormatException;

public class ResultActivity extends AppCompatActivity {
    EditText edtGeta,edtGetb;
    Button btnsend;
    Intent myIntent;
    int s=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        edtGeta = findViewById(R.id.editGetA);
        edtGetb = findViewById(R.id.editGetB);
        btnsend = findViewById(R.id.btnGuiKq);
        myIntent = getIntent();
        int a = myIntent.getIntExtra("soa",1);
        int b = myIntent.getIntExtra("sob",1);
        edtGeta.setText(a+"");
        edtGetb.setText(b+"");
        s = a + b;
        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myIntent.putExtra("kq",s);
                setResult(33,myIntent);
                finish();
            }
        });
    }
}