package com.example.lehuunhatkhoa__kt2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.icu.text.DecimalFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtTT;
    EditText edtTenKH,edtSoLuong,edtTongKH,edtTongKHV,edtTDT;
    CheckBox cbVip;
    Button btnTT, btnTiep, btnTK;
    ImageButton btnExit;
    double[] kq = new double[3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtTT = findViewById(R.id.txtTT);

        edtTenKH = findViewById(R.id.edtTenKH);
        edtSoLuong = findViewById(R.id.edtSoLuong);
        edtTongKH = findViewById(R.id.edtTongKH);
        edtTongKHV = findViewById(R.id.edtTongKHV);
        edtTDT = findViewById(R.id.edtTDT);

        cbVip = findViewById(R.id.cbVip);

        btnTT = findViewById(R.id.btnTT);
        btnTiep = findViewById(R.id.btnTiep);
        btnTK= findViewById(R.id.btnTK);

        btnExit = findViewById(R.id.btnExit);

        btnTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soLuong = Integer.parseInt(edtSoLuong.getText().toString());
                double tongTien = 0;
                if(cbVip.isChecked()){
                    tongTien = soLuong*0.9*20000;
                }else{
                    tongTien = soLuong*20000;
                }
                txtTT.setText(""+tongTien);
            }
        });

        btnTiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kq[0]++;
                if(cbVip.isChecked()) kq[1]++;
                kq[2]+= Double.parseDouble(txtTT.getText().toString());
                edtTenKH.setText("");
                edtSoLuong.setText("0");
                txtTT.setText("0");
                edtTenKH.requestFocus();
            }
        });

        btnTK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtTongKH.setText((int)kq[0]+"");
                edtTongKHV.setText((int)kq[1]+"");
                edtTDT.setText(kq[2]+"");
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
                b.setTitle("Question?");
                b.setMessage("Are you sure you want to exit???");
                b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                b.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                b.create().show();
            }
        });
    }
}