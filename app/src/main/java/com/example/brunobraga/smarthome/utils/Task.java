package com.example.brunobraga.smarthome.utils;

import java.util.ArrayList;

/**
 * Created by brunobraga on 26/09/16.
 */
public class Task {
    private String taskDescription;
    private String taskCreationDate;
    private String dateLimit;
    private User taskAssigner;
    private ArrayList<User> taskPartners;
    private ArrayList<Comments> comments;

    public Task(String taskDescription, String taskCreationDate, String dateLimit, User taskAssigner, ArrayList<User> taskPartners, ArrayList<Comments> comments){
        this.taskDescription = taskDescription;
        this.taskCreationDate = taskCreationDate;
        this.dateLimit = dateLimit;
        this.taskAssigner = taskAssigner;
        this.taskPartners = taskPartners;
        this.comments = comments;
    }

    public String getTaskDescription(){
        return this.taskDescription;
    }

    public String getDateLimit(){
        return this.dateLimit;
    }

    public String getTaskCreationDate(){
        return this.taskCreationDate;
    }

    public User getTaskAssigner(){
        return taskAssigner;
    }

    public ArrayList<User> getTaskPartners(){
        return taskPartners;
    }

    public ArrayList<Comments> getComments(){
        return comments;
    }
}
