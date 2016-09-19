package com.example.brunobraga.smarthome.utils;

/**
 * Created by brunobraga on 18/09/16.
 */
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.brunobraga.smarthome.R;

import java.util.ArrayList;

public class CustomListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final ArrayList itemname;
    private final ArrayList imgid;

    public CustomListAdapter(Activity context, ArrayList itemname, ArrayList imgid) {
        super(context, R.layout.custom_list_view, itemname);
        // TODO Auto-generated constructor stub
        this.context=context;
        this.itemname=itemname;
        this.imgid=imgid;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.custom_list_view, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.customListViewTextView);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.customListViewImageView);

        txtTitle.setText(itemname.get(position).toString());
        imageView.setImageResource((Integer) imgid.get(position));
        return rowView;

    };

    public void remove(String name){
        this.imgid.remove(this.itemname.indexOf(name));
        this.itemname.remove(name);

    }
    public void updateImage(Integer pos, Integer image){
        this.imgid.set(pos,image);
    }
    public void add(String name, Integer image){
        this.itemname.add(name);
        this.imgid.add(image);
    }
    public Integer getPos(String name){
        return this.itemname.indexOf(name);
    }
}