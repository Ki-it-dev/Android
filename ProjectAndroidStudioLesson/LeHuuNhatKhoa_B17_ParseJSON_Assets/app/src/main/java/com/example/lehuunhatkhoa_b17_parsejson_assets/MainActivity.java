package com.example.lehuunhatkhoa_b17_parsejson_assets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnparse;
    ListView lv1;
    ArrayList<String>mylist;
    ArrayAdapter myadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnparse = findViewById(R.id.btnparse);
        lv1 = findViewById(R.id.lv1);
        mylist = new ArrayList<>();
        myadapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,mylist);
        lv1.setAdapter(myadapter);
        btnparse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parsejson();
            }
            private void parsejson(){
                String json = null;
                try{
                    InputStream inputStream = getAssets().open("computer.json");
                    int size = inputStream.available();
                    byte[] buffer = new byte[size];
                    inputStream.read(buffer);
                    inputStream.close();
                    json = new String(buffer,"UTF-8");
                    JSONObject reader = new JSONObject(json);
                    mylist.add(reader.getString("MaDM"));
                    mylist.add(reader.getString("TenDM"));
                    JSONArray myarray = reader.getJSONArray("Sanphams");
                    for (int i = 0;i<myarray.length();i++)
                    {
                        JSONObject myobj = myarray.getJSONObject(i);
                        mylist.add(myobj.getString("MaSP")+" - "+myobj.getString("TenSP"));
                        mylist.add(myobj.getString("SoLuong")+" * "+myobj.getString("DonGia")+" = "+myobj.getString("ThanhTien"));
                        mylist.add(myobj.getString("Hinh"));
                    }
                    myadapter.notifyDataSetChanged();

                }catch (IOException e1){
                    e1.printStackTrace();
                }catch (JSONException e2){
                    e2.printStackTrace();
                }
            };
        });
    }
}