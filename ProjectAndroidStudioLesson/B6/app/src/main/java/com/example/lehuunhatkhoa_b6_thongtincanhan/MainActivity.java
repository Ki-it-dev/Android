package com.example.lehuunhatkhoa_b6_thongtincanhan;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtTen,edtCMND,edtBoSung;
    RadioGroup idGroup;
    Button btnSend;
    CheckBox cbSach,cbBao,cbCoding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtTen = findViewById(R.id.editFullName);
        edtCMND = findViewById(R.id.editCMND);
        edtBoSung = findViewById(R.id.editBoSung);
        idGroup = findViewById(R.id.rdGroup);
        btnSend = findViewById(R.id.btnGuiThongTin);
        cbBao = findViewById(R.id.checkBoxBao);
        cbCoding = findViewById(R.id.checkBoxCoding);
        cbSach = findViewById(R.id.checkBoxSach);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInformation();
            }
        });
    }
    public void showInformation(){
        String ten = edtTen.getText().toString();
        ten = ten.trim();
        if(ten.length()<3){
            edtTen.requestFocus();
            edtTen.selectAll();
            Toast.makeText(this,"Tên phải nhiều hơn 3 kí tự",Toast.LENGTH_LONG).show();
            return;
        }

        String cmnd = edtCMND.getText().toString();
        cmnd = cmnd.trim();
        if(cmnd.length() != 9){
            edtCMND.requestFocus();
            edtCMND.selectAll();
            Toast.makeText(this, "CMND phải có 9 kí tự", Toast.LENGTH_LONG).show();
            return;
        }

        String bang = "";
        int id = idGroup.getCheckedRadioButtonId();
        if(id == -1){
            Toast.makeText(this, "Chọn bằng cấp", Toast.LENGTH_SHORT).show();
            return;
        }
        RadioButton rad = findViewById(id);
        bang = rad.getText()+"";

        String SoThich="";
        if(cbBao.isChecked())
            SoThich+=cbBao.getText()+"\n";
        if(cbSach.isChecked())
            SoThich+=cbSach.getText()+"\n";
        if(cbCoding.isChecked())
            SoThich+=cbCoding.getText()+"\n";

        String boSung = edtBoSung.getText().toString();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        String msg = ten+"\n";
        msg+= cmnd+"\n";
        msg+= bang+"\n";
        msg+= SoThich+"\n";
        msg+="------------\n";
        msg+= "Thông tin bổ sung:\n";
        msg+= boSung+"\n";
        msg+="------------";
        builder.setMessage(msg);

        builder.setTitle("Thông tin cá nhân");
        builder.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.create().show();
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