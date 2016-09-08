package com.example.brunobraga.smarthome.utils;

import android.net.Uri;
import android.text.Editable;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by brunobraga on 06/09/16.
 */
@IgnoreExtraProperties
public class User{
    public String username;
    public String email;
    public  String photoUrl;
    public String userUid;
    public String nickName;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String username, String email, String photoUrl, String userUid,String nickName) {
        this.username = username;
        this.email = email;
        this.photoUrl = photoUrl;
        this.userUid = userUid;
        this.nickName = nickName;
    }

    public void setUpUserNickName(String nickName){
        this.nickName = nickName;
    }

}