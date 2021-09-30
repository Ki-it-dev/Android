package com.example.lehuunhatkhoa_b8_call_sms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendActivity extends AppCompatActivity {
    EditText edtSms;
    Button btnback2,btnSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        edtSms = findViewById(R.id.editSms);
        btnback2 = findViewById(R.id.btnBack2);
        btnSend = findViewById(R.id.btnSend);
        btnback2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sms = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+edtSms.getText().toString()));
                startActivity(sms);
            }
        });
    }
}