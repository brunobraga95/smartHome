package com.example.brunobraga.smarthome.utils;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.brunobraga.smarthome.R;

import java.util.ArrayList;

/**
 * Created by brunobraga on 23/09/16.
 */
public class CustomListAdapterCancelFriends extends CustomListAdapter {
    public CustomListAdapterCancelFriends(Activity context, ArrayList itemname, ArrayList imgid,ArrayList subTitles) {
        super(context, itemname, imgid,subTitles);
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.custom_list_view, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.customListViewTextView);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.customListViewImageView);

        txtTitle.setText(itemname.get(position).toString());

        //txtTitle.setTextSize(100);
        imageView.setImageResource((Integer) imgid.get(position));
        return rowView;

    };


}
