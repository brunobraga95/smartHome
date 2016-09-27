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
    private String username;
    private String email;
    private  String photoUrl;
    private String userUid;
    private String nickName;
    private String groups;

    private User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String username, String email, String photoUrl, String userUid,String nickName) {
        this.username = username;
        this.email = email;
        this.photoUrl = photoUrl;
        this.userUid = userUid;
        this.nickName = nickName;
        this.groups = "/";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getUserUid() {
        return userUid;
    }

    public void setUserUid(String userUid) {
        this.userUid = userUid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getGroups() {
        return groups;
    }

    public void setGroups(String groups) {
        this.groups = groups;
    }
}