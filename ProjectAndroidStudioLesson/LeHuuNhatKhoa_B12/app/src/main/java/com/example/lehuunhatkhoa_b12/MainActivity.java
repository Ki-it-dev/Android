package com.example.lehuunhatkhoa_b12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtSelect;
    AutoCompleteTextView singleComplete;
    MultiAutoCompleteTextView multiComplete;
    String arr[]={
            "Hà Nội","Huế","Sài Gòn","Đà Nẵng","Đà Lạt","Hội An","Kiên Giang","Quảng Nam"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtSelect = findViewById(R.id.txtSelect);
        singleComplete = findViewById(R.id.autoCompleteTextView);
        multiComplete = findViewById(R.id.multiAutoCompleteTextView);
        ArrayAdapter myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arr);
        singleComplete.setAdapter(myAdapter);
        multiComplete.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arr));
        multiComplete.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        singleComplete.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                txtSelect.setText(singleComplete.getText());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}