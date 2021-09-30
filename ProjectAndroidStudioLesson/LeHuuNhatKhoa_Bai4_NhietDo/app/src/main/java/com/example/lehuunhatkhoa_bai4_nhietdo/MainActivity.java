package com.example.lehuunhatkhoa_bai4_nhietdo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText editTextC,editTextF;
    Button btnCf,btnFc,btnClear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextC = findViewById(R.id.editC);
        editTextF = findViewById(R.id.editF);
        btnCf = findViewById(R.id.btnCf);
        btnFc = findViewById(R.id.btnFc);
        btnClear = findViewById(R.id.btnClear);

        btnCf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat dcf = new DecimalFormat("#.00");
                int doC = Integer.parseInt(editTextC.getText().toString());
                double doF = doC * 9.0/5 + 32;
                editTextF.setText(""+dcf.format(doF));
            }
        });

        btnFc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat dcf = new DecimalFormat("#.00");
                int doF = Integer.parseInt(editTextF.getText().toString());
                double doC = (doF - 32)*5.0/9;
                editTextC.setText(""+dcf.format(doC));
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextC.setText("");
                editTextF.setText("");
                editTextF.requestFocus();
            }
        });

    }
}