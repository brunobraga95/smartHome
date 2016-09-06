package com.example.brunobraga.smarthome;

import android.net.Uri;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;

/**
 * Created by brunobraga on 06/09/16.
 */
@IgnoreExtraProperties
public class User{

    public String username;
    public String email;
    public  String photoUrl;
    public String userUid;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String username, String email, String photoUrl, String userUid) {
        this.username = username;
        this.email = email;
        this.photoUrl = photoUrl;
        this.userUid = userUid;
    }

}