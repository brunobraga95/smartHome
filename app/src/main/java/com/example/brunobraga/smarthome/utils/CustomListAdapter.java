package com.example.brunobraga.smarthome.utils;

/**
 * Created by brunobraga on 18/09/16.
 */
import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.brunobraga.smarthome.R;

import java.util.ArrayList;

public class CustomListAdapter extends ArrayAdapter<String> {

    private Activity context;
    private ArrayList itemName;
    private ArrayList imgId;
    private ArrayList subTitles;

    public CustomListAdapter(Activity context, ArrayList itemname, ArrayList imgid,ArrayList subTitles) {
        super(context, R.layout.custom_list_view, itemname);
        // TODO Auto-generated constructor stub
        this.context=context;
        this.itemName=itemname;
        this.imgId=imgid;
        this.subTitles = subTitles;
    }


    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.custom_list_view, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.customListViewTextView);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.customListViewImageView);

        txtTitle.setText(itemName.get(position).toString());

        imageView.setImageResource((Integer) imgId.get(position));
        return rowView;

    };


    public void remove(String name){
        this.imgId.remove(this.itemName.indexOf(name));
        this.itemName.remove(name);

    }
    public void updateImage(Integer pos, Integer image){
        this.imgId.set(pos,image);
    }
    public void add(String name, Integer image){
        this.itemName.add(name);
        this.imgId.add(image);
    }
    public Integer getPos(String name){
        return this.itemName.indexOf(name);
    }

    public Activity getContextListAdapter() {
        return context;
    }

    public void getContextListAdapterListAdapter(Activity context) {
        this.context = context;
    }

    public ArrayList getItemName() {
        return itemName;
    }

    public void setItemName(ArrayList itemName) {
        this.itemName = itemName;
    }

    public ArrayList getSubTitles() {
        return subTitles;
    }

    public void setSubTitles(ArrayList subTitles) {
        this.subTitles = subTitles;
    }

    public ArrayList getImgId() {
        return imgId;
    }

    public void setImgId(ArrayList imgId) {
        this.imgId = imgId;
    }
}