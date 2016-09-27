package com.example.brunobraga.smarthome.utils;

/**
 * Created by brunobraga on 26/09/16.
 */
public class Comments {
    private User commentCreater;
    private String commentDate;
    private String comment;

    public Comments(User commentCreater,String commentDate,String comment){
        this.commentCreater = commentCreater;
        this.commentDate = commentDate;
        this.comment = comment;
    }

    public User getCommentCreater() {
        return commentCreater;
    }

    public void setCommentCreater(User commentCreater) {
        this.commentCreater = commentCreater;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
