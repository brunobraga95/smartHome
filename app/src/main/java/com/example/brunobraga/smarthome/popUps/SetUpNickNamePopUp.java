package com.example.brunobraga.smarthome.popUps;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.EditText;

/**
 * Created by brunobraga on 07/09/16.
 */
public class SetUpNickNamePopUp {
    public AlertDialog.Builder setUpNickNameDialog;
    public EditText setUpNickNameEditText;
    public AlertDialog setUpNickNameAlertDialog;

    public SetUpNickNamePopUp(AlertDialog.Builder alertDialogBuilder, EditText et ){
        this.setUpNickNameDialog = alertDialogBuilder;
        this.setUpNickNameEditText = et;
        this.setUpNickNameDialog.setView(et);
        this.setUpNickNameDialog.setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });

        // create alert dialog
        this.setUpNickNameAlertDialog = this.setUpNickNameDialog.create();
        // show it

    }
}
