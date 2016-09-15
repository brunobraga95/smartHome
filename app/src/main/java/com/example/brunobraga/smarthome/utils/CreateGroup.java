package com.example.brunobraga.smarthome.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by brunobraga on 12/09/16.
 */
public class CreateGroup {
    Map<String, Object> members = new HashMap<String, Object>();
    public CreateGroup(String groupName, ArrayList members) {
        for(int i=0;i<members.size();i++){
            Map<String, Object> nickname = new HashMap<String, Object>();
            this.members.put(members.get(i).toString(),"Enter User UID");
        }
    }


}
