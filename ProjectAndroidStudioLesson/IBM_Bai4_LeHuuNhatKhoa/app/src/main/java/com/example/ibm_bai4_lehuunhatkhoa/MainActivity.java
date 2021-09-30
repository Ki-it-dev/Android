package com.example.ibm_bai4_lehuunhatkhoa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText editTen,editChieuCao,editCanNang,editBMI,editChuanDoan;
    Button btnBMI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTen = findViewById(R.id.editTen);
        editChieuCao = findViewById(R.id.editChieuCao);
        editCanNang = findViewById(R.id.editCanNang);
        editBMI = findViewById(R.id.editBMI);
        editChuanDoan = findViewById(R.id.editChuanDoan);
        btnBMI = findViewById(R.id.btnBMI);
        btnBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double H = Double.parseDouble(editChieuCao.getText()+"");
                double W = Double.parseDouble(editCanNang.getText()+"");
                double BMI=W/Math.pow(H,2);
                String chuanDoan="";
                if(BMI < 18){
                    chuanDoan="Bạn gầy";
                }
                else if(BMI <= 24.9){
                    chuanDoan="Bạn bình thường";
                }
                else if(BMI <= 29.9){
                    chuanDoan="Bạn béo phì độ 1";
                }
                else if(BMI <= 34.9){
                    chuanDoan="Bạn béo phì độ 2";
                }
                else{
                    chuanDoan="Bạn béo phì độ 3";
                }
                DecimalFormat dcf = new DecimalFormat("#.0");
                editBMI.setText(dcf.format(BMI));
                editChuanDoan.setText(chuanDoan);
            }
        });
    }
}