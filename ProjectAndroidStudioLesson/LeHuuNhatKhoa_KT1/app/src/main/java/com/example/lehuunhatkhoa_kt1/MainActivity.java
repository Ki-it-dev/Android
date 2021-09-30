package com.example.lehuunhatkhoa_kt1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText edtVND,edtNgoai;
    RadioGroup rdGroup;
    RadioButton rdUSD,rdEUR,rdJPY;
    Button btnVNDtoNgoaiTe,btnNgoaiTeToVND,btnClear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNgoai = findViewById(R.id.editNgoaiTe);
        edtVND = findViewById(R.id.editVND);
        rdGroup = findViewById(R.id.rdGroup);
        rdEUR = findViewById(R.id.rdEUR);
        rdJPY = findViewById(R.id.rdJPY);
        rdUSD = findViewById(R.id.rdUSD);
        btnNgoaiTeToVND = findViewById(R.id.btnNgoaiTeToVND);
        btnClear = findViewById(R.id.btnClear);
        btnVNDtoNgoaiTe = findViewById(R.id.btnVNToNgoaiTe);
        btnNgoaiTeToVND.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat dcf = new DecimalFormat("#.0");
                int id = rdGroup.getCheckedRadioButtonId();
                String Ngoai = edtNgoai.getText().toString();
                double Ng = Double.parseDouble(Ngoai);
                if(id == -1){
                    Toast.makeText(MainActivity.this, "Chọn ngoại tệ để chuyển đổi!", Toast.LENGTH_LONG).show();
                    return;
                }else {
                    if(rdUSD.isChecked()){
                        edtVND.setText(""+dcf.format(Ng*22280));
                    }
                    else if(rdEUR.isChecked()){
                        edtVND.setText(""+dcf.format(Ng*24280));
                    }
                    else{
                        edtVND.setText(""+dcf.format(Ng*204));
                    }
                }
            }
        });
        btnVNDtoNgoaiTe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat dcf = new DecimalFormat("#.0");
                int id = rdGroup.getCheckedRadioButtonId();
                String VND = edtVND.getText().toString();
                double VN = Double.parseDouble(VND);
                if(id == -1){
                    Toast.makeText(MainActivity.this, "Chọn ngoại tệ để chuyển đổi!", Toast.LENGTH_LONG).show();
                    return;
                }
                else{
                    if(rdUSD.isChecked()){
                        edtNgoai.setText(""+dcf.format(VN/22280));
                    }
                    else if(rdEUR.isChecked()){
                        edtNgoai.setText(""+dcf.format(VN/24280));
                    }
                    else{
                        edtNgoai.setText(""+dcf.format(VN/204));
                    }
                }
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtNgoai.setText("");
                edtVND.setText("");
                edtVND.requestFocus();
            }
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
        b.setTitle("Question");
        b.setMessage("Are you want to exit?");
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

}