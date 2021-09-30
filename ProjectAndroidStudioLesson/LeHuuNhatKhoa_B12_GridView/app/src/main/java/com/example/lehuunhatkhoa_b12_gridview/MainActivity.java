package com.example.lehuunhatkhoa_b12_gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String arr[]={
            "Ipad","Iphone","Nokia","Sony","SamSung","SamSungGalaxy",
            "SamSungGalaxy S7","SamSungGalaxy J7","Apple","BlackBerry","HTC"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView selection = (TextView)findViewById(R.id.txtSelection);
        final GridView gv = (GridView)findViewById(R.id.gv1);
        ArrayAdapter<String>data = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arr);
        gv.setAdapter(data);
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selection.setText(arr[position]);
            }
        });
    }
}