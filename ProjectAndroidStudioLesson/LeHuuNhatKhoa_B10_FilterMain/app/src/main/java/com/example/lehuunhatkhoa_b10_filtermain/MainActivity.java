package com.example.lehuunhatkhoa_b10_filtermain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edtlink;
    Button btnopen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtlink = findViewById(R.id.editLink);
        btnopen = findViewById(R.id.btnOpen);
        btnopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+edtlink.getText().toString()));
                startActivity(myintent);
            }
        });
    }
}