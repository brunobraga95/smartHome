package com.example.brunobraga.smarthome.utils;

import java.util.ArrayList;

/**
 * Created by brunobraga on 11/09/16.
 */

public class usefull {
    public ArrayList selectedFriends = new ArrayList();
    void useful(){

    }
    public void updateSelectedFriends(String name){
        if(selectedFriends.isEmpty()){
            selectedFriends.add(name);
            return;
        }
        if(selectedFriends.contains(name))selectedFriends.remove(name);
        else selectedFriends.add(name);

    }
}



