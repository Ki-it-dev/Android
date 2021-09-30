package com.example.lehuunhatkhoa_b13_custom2;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
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

public class myArrayAdapter extends ArrayAdapter<image> {
    Activity context = null;
    ArrayList<image> myArray = null;
    int LayoutId;

    public myArrayAdapter(Activity context, ArrayList<image> myArray, int layoutId) {
        super(context, layoutId, myArray);
        this.context = context;
        this.myArray = myArray;
        LayoutId = layoutId;
    }

    @NonNull
    @Override
    public Activity getContext() {
        return context;
    }

    public ArrayList<image> getMyArray() {
        return myArray;
    }

    public int getLayoutId() {
        return LayoutId;
    }

    public void setContext(Activity context) {
        this.context = context;
    }

    public void setMyArray(ArrayList<image> myArray) {
        this.myArray = myArray;
    }

    public void setLayoutId(int layoutId) {
        LayoutId = layoutId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(LayoutId,null);
        final image myimage = myArray.get(position);
        final ImageView imgitem = (ImageView)convertView.findViewById(R.id.imgView1);
        imgitem.setImageResource(myimage.getImg());
        final TextView myname = (TextView)convertView.findViewById(R.id.txtView1);
        myname.setText(myimage.getName());
        return convertView;
    }

}
