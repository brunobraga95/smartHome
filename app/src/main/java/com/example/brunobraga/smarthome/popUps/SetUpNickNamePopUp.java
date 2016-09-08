package com.example.brunobraga.smarthome.popUps;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.view.Gravity;
import android.widget.EditText;

import com.example.brunobraga.smarthome.utils.User;

/**
 * Created by brunobraga on 07/09/16.
 */
public class SetUpNickNamePopUp {
    public AlertDialog.Builder setUpNickNameDialog;
    public EditText setUpNickNameEditText;
    public AlertDialog setUpNickNameAlertDialog;

    public SetUpNickNamePopUp(AlertDialog.Builder alertDialogBuilder, EditText et,String userName){
        alertDialogBuilder.setTitle("Welcome "+userName);
        alertDialogBuilder.setMessage("Please Choose a Nick name");
        this.setUpNickNameDialog = alertDialogBuilder;
        this.setUpNickNameEditText = et;
        this.setUpNickNameDialog.setView(et);

    /*
        this.setUpNickNameDialog.setCancelable(true).setPositiveButton("OK", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int id) {
                //user.setUpUserNickName(input.getText().toString());
            }

        });
      */
        // create alert dialog
        this.setUpNickNameAlertDialog = this.setUpNickNameDialog.create();
    }

    public EditText getInput(){
        final EditText input = this.setUpNickNameEditText;
        return input;
    }

}
