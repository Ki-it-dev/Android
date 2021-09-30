package com.example.lehuunhatkhoa_b13_custom1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String namePhone[]={
            "SamSungGalaxy J3",
            "SamSungGalaxy J7",
            "SamSungGalaxy Plus",
            "SamSungGalaxy A30",
            "SamSungGalaxy Pro",
            "SamSungGalaxy ProMax",
    };
    int imagePhone[] = {
            R.drawable.ip,
            R.drawable.samsung,
            R.drawable.htc,
            R.drawable.wp,
            R.drawable.lg,
            R.drawable.sky
    };
    int pricePhone[]={
            1000000,
            2000000,
            3000000,
            4000000,
            5000000,
            6000000,
    };
    ArrayList<Phone> myList;
    myArrayAdapter myAdapter;
    ListView lv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myList = new ArrayList<>();
        for (int i=0;i<namePhone.length;i++){
            myList.add(new Phone(namePhone[i],imagePhone[i],pricePhone[i]));
        }
        myAdapter = new myArrayAdapter(MainActivity.this,R.layout.layout_listview,myList);
        lv1 = findViewById(R.id.lv1);
        lv1.setAdapter(myAdapter);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(MainActivity.this,SubActivity.class);
                myIntent.putExtra("name:",namePhone[position]);
                myIntent.putExtra("price:",pricePhone[position]);
                startActivity(myIntent);
            }
        });
    }
}