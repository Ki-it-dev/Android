package com.example.lehuunhatkhoa_b11_listview1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtselect;
    String myPhone[]={
            "IPhone 12 Promax",
            "SamSung Galaxy S20",
            "Opp Neo 7",
            "Nokia Lumia 9",
            "HTC One E9",
            "Sony Xperia XZ"
    };
    ArrayAdapter<String> myadapter;
    ListView lv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myadapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,myPhone);
        lv1 = findViewById(R.id.lv1);
        txtselect = findViewById(R.id.txtPhone);
        lv1.setAdapter(myadapter);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                txtselect.setText("Vị trí "+ i + " : "+myPhone[i]);
            }
        });
    }
}