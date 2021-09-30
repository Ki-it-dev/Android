package com.example.lehuunhatkhoa_b10_filterwebview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    WebView myweb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myweb = findViewById(R.id.myweb);
        Intent myintent = getIntent();
        Uri link = myintent.getData();
        try{
            myweb.loadUrl(link.toString());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}