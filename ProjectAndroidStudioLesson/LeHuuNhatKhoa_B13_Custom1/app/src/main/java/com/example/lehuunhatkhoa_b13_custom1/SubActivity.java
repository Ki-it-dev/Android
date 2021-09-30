package com.example.lehuunhatkhoa_b13_custom1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {
    TextView txtSubPhone,txtPriceSubPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        txtSubPhone = findViewById(R.id.txtSubPhone);
        txtPriceSubPhone = findViewById(R.id.txtSubPrice);
        Intent myIntent = getIntent();
        String namePhone = myIntent.getStringExtra("name:");
        int pricePhone = myIntent.getIntExtra("price:",1);
        txtSubPhone.setText(""+namePhone);
        txtPriceSubPhone.setText("Giá bán: "+pricePhone);
    }
}