package com.example.brunobraga.smarthome;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GroupScreen extends AppCompatActivity {
    private Bundle bundle;
    private String groupName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bundle = getIntent().getExtras();
        groupName = bundle.getString("currentGroup");

        TextView groupNameTextView = (TextView)findViewById(R.id.groupNameTextView);
        groupNameTextView.setText(groupName);
        
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.yourTasksButton:{
                Button yourTasksButton = (Button)findViewById(R.id.yourTasksButton);
                Button allTasksButton = (Button)findViewById(R.id.allTasksButton);

                Resources res = getResources();
                Drawable drawSelected = res.getDrawable( R.drawable.tab_host_button_shape_selected);
                Drawable drawUnselected = res.getDrawable( R.drawable.tab_host_button_shape_unselected);

                yourTasksButton.setTextColor(Color.parseColor("#000000"));
                allTasksButton.setTextColor(Color.parseColor("#FFFFFF"));

                yourTasksButton.setBackgroundDrawable(drawSelected);
                allTasksButton.setBackgroundDrawable(drawUnselected);
                break;
            }
            case R.id.allTasksButton:{
                Button yourTasksButton = (Button)findViewById(R.id.yourTasksButton);
                Button allTasksButton = (Button)findViewById(R.id.allTasksButton);

                Resources res = getResources();
                Drawable drawSelected = res.getDrawable( R.drawable.tab_host_button_shape_selected);
                Drawable drawUnselected = res.getDrawable( R.drawable.tab_host_button_shape_unselected);

                yourTasksButton.setTextColor(Color.parseColor("#FFFFFF"));
                allTasksButton.setTextColor(Color.parseColor("#000000"));

                yourTasksButton.setBackgroundDrawable(drawUnselected);
                allTasksButton.setBackgroundDrawable(drawSelected);
                break;
            }
        }
    }

}
