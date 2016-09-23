package com.example.brunobraga.smarthome.utils;

import android.app.Activity;

import java.util.ArrayList;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.brunobraga.smarthome.R;

/**
 * Created by brunobraga on 23/09/16.
 */
public class CustomListAdapterGroupsTab extends CustomListAdapter{
    public CustomListAdapterGroupsTab(Activity context, ArrayList itemname, ArrayList imgid,ArrayList subTitles) {
        super(context, itemname, imgid,subTitles);
    }


    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.custom_list_view, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.customListViewTextView);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.customListViewImageView);

        txtTitle.setText(itemname.get(position).toString());

        txtTitle.setTextSize(25);

       // TextView txtSubTitle = (TextView) rowView.findViewById(R.id.customListViewSubTextView);

        //txtSubTitle.setText(subTitles.get(position).toString());

        imageView.setImageResource((Integer) imgid.get(position));
        return rowView;

    };

}
