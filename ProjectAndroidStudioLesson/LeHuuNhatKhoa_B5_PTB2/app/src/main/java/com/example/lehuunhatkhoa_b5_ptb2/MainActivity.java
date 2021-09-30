package com.example.lehuunhatkhoa_b5_ptb2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText edta,edtb,edtc;
    Button btnTiepTuc,btnGiai,btnThoat;
    TextView txtNghiem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edta = findViewById(R.id.editA);
        edtb = findViewById(R.id.editB);
        edtc = findViewById(R.id.editC);
        btnGiai = findViewById(R.id.btnGiai);
        btnThoat = findViewById(R.id.btnThoat);
        btnTiepTuc = findViewById(R.id.btnTiepTuc);
        txtNghiem = findViewById(R.id.txtNghiem);
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnTiepTuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edta.setText("");
                edtb.setText("");
                edtc.setText("");
                edta.requestFocus();
            }
        });
        btnGiai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sa = edta.getText()+"";
                String sb = edtb.getText()+"";
                String sc = edtc.getText()+"";
                int a = Integer.parseInt(sa);
                int b = Integer.parseInt(sb);
                int c = Integer.parseInt(sc);
                String kq="";
                DecimalFormat dcf = new DecimalFormat("#.00");
                if(a==0){
                    if(b==0){
                        if(c==0){
                            kq="PT vo so nghiem";
                        }
                        else{
                            kq="PT vo nghiem";
                        }
                    }
                    else{
                        kq="PT co 1 nghiem, x = "+dcf.format(-c/b);
                    }
                }
                else{
                    double delta = b*b-4*a*c;
                    if(delta<0)
                        kq="PT vo nghiem";
                    else if(delta==0)
                        kq="PT co nghiem kep x1=x2= "+dcf.format(-b/(2*a));
                    else{
                        kq="PT co 2 nghiem : x1= "+dcf.format((-b+Math.sqrt(delta))/(2*a))
                                +"; x2= "+dcf.format((-b-Math.sqrt(delta))/(2*a));
                    }
                }
                txtNghiem.setText(kq);
            }
        });
    }
}