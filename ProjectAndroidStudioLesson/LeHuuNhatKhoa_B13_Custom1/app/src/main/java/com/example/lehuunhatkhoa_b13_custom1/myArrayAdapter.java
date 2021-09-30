package com.example.lehuunhatkhoa_b13_custom1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class myArrayAdapter extends ArrayAdapter<Phone> {
    Activity context1;
    int idLayout1;
    ArrayList<Phone> myList1;

    public myArrayAdapter(Activity context, int idLayout, ArrayList<Phone> myList) {
        super(context, idLayout, myList);
        context1 = context;
        idLayout1 = idLayout;
        myList1 = myList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater myLactor = context1.getLayoutInflater();
        convertView = myLactor.inflate(idLayout1,null);
        Phone myPhone = myList1.get(position);

        ImageView imgPhone = convertView.findViewById(R.id.imgPhone);
        imgPhone.setImageResource(myPhone.getImagePhone());

        TextView txtNamePhone = convertView.findViewById(R.id.txtPhone);
        txtNamePhone.setText(myPhone.getNamePhone());

        TextView txtPricePhone = convertView.findViewById(R.id.txtPrice);
        txtPricePhone.setText("Giá bán: "+myPhone.getPricePhone());

        return convertView;
    }
}
