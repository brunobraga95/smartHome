package com.example.brunobraga.smarthome.utils;

import java.util.ArrayList;

/**
 * Created by brunobraga on 11/09/16.
 */

public class UseFull {
    private ArrayList selectedFriends = new ArrayList();

    void UseFull(){
        selectedFriends = new ArrayList();
    }


    public void updateSelectedFriends(String name){
        if(this.selectedFriends.isEmpty()){
            selectedFriends.add(name);
            return;
        }
        if(selectedFriends.contains(name))selectedFriends.remove(name);
        else selectedFriends.add(name);

    }

    public ArrayList getSelectedFriends() {
        return selectedFriends;
    }

    public void setSelectedFriends(ArrayList selectedFriends) {
        this.selectedFriends = selectedFriends;
    }
}



