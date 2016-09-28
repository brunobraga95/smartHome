package com.example.brunobraga.smarthome.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by brunobraga on 12/09/16.
 */
public class CreateGroup {
    private Map<String, Object> members = new HashMap<String, Object>();
    private String dateCreation;
    private ArrayList<Task> groupTasks;

    public CreateGroup(ArrayList members, String dateCreation) {
        for(int i=0;i<members.size();i++){
            this.members.put(members.get(i).toString(),"Enter User UID");
        }
        this.dateCreation = dateCreation;

    }

    public Map<String, Object> getMembers() {
        return members;
    }

    public void setMembers(Map<String, Object> members) {
        this.members = members;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }
}
