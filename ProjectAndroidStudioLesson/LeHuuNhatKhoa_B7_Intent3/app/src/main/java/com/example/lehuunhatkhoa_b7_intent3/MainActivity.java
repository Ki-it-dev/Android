package com.example.lehuunhatkhoa_b7_intent3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edta,edtb,edtkq;
    Button btnkq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edta = findViewById(R.id.editA);
        edtb = findViewById(R.id.editB);
        edtkq = findViewById(R.id.editKq);
        btnkq = findViewById(R.id.btnKq);

        btnkq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this,ResultActivity.class);
                int a = Integer.parseInt(edta.getText().toString());
                int b = Integer.parseInt(edtb.getText().toString());
                myIntent.putExtra("soa",a);
                myIntent.putExtra("sob",b);
                startActivityForResult(myIntent,99);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 99 && resultCode == 33){
            int s = data.getIntExtra("kq",2);
            edtkq.setText(s+"");
        }
    }
}