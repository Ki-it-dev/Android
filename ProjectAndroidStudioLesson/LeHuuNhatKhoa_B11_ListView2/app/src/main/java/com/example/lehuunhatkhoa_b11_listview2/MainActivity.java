package com.example.lehuunhatkhoa_b11_listview2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> arrayWork;
    ArrayAdapter<String> arrayAdapter;
    EditText edtwork,edtH,edtM;
    TextView txtdate;
    Button btnadd;
    ListView lv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtH = findViewById(R.id.editHour);
        edtM = findViewById(R.id.editMinute);
        edtwork = findViewById(R.id.editWorks);
        btnadd = findViewById(R.id.btnAddWork);
        txtdate = findViewById(R.id.txtdate);
        lv1 = findViewById(R.id.lv1);

        arrayWork = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arrayWork);
        lv1.setAdapter(arrayAdapter);

        Date currentDate = Calendar.getInstance().getTime();
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy");
        txtdate.setText("Hôm nay : "+simpleDateFormat.format(currentDate));

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtH.getText().toString().equals("") || edtM.getText().toString().equals("") || edtwork.getText().toString().equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Info missing");
                    builder.setMessage("Please enter all information of the work");
                    builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    builder.create().show();
                }else{
                    String str = edtwork.getText().toString() + " - " + edtH.getText().toString() + ":" + edtM.getText().toString();
                    arrayWork.add(str);
                    arrayAdapter.notifyDataSetChanged();
                    edtM.setText("");
                    edtH.setText("");
                    edtwork.setText("");
                }
            }
        });

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                arrayWork.remove(position);
                arrayAdapter.notifyDataSetChanged();
            }
        });

    }
}