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
        Activity context = this.getContextListAdapter();
        ArrayList itemName = this.getItemName();
        ArrayList imgId = this.getImgId();
        ArrayList subTitles = this.getSubTitles();

        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.custom_list_view, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.customListViewTextView);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.customListViewImageView);
        TextView txtSubTitle = (TextView) rowView.findViewById(R.id.customListViewSubTextView);

        txtTitle.setText(itemName.get(position).toString());
        imageView.setImageResource((Integer) imgId.get(position));
        txtSubTitle.setText(subTitles.get(position).toString());

        txtTitle.setTextSize(25);

        return rowView;

    };

}
