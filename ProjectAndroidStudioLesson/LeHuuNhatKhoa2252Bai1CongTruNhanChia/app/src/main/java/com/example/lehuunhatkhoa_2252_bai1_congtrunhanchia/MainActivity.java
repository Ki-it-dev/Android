package com.example.lehuunhatkhoa_2252_bai1_congtrunhanchia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    //Khai bao bien
    EditText edita ,editb ,editketqua;
    Button btnCong;
    Button btnTru;
    Button btnNhan;
    Button btnChia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Tham chieu ID cho cac doi tuong co tren giao dien
        edita = findViewById(R.id.editA);
        editb = findViewById(R.id.editB);
        editketqua = findViewById(R.id.editKQ);
        btnCong = findViewById(R.id.btnTong);
        btnTru = findViewById(R.id.btnHieu);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);
        //Xu ly chuc nang
        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(edita.getText().toString());
                int b = Integer.parseInt(editb.getText().toString());
                int kq = a + b;
                editketqua.setText("Tổng là : "+kq);
            }
        });

        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(edita.getText().toString());
                int b = Integer.parseInt(editb.getText().toString());
                int kq = a - b;
                editketqua.setText("Hiệu là : "+kq);
            }
        });

        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(edita.getText().toString());
                int b = Integer.parseInt(editb.getText().toString());
                int kq = a * b;
                editketqua.setText("Tích là : "+kq);
            }
        });

        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(edita.getText().toString());
                int b = Integer.parseInt(editb.getText().toString());
                int kq = a / b;
                editketqua.setText("Thương là : "+kq);
            }
        });

    }
}