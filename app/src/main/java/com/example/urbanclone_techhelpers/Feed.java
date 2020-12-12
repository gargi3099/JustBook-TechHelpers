package com.example.urbanclone_techhelpers;

public class Feed {
    String email,comment,techemail;
    String rating;
    public Feed() {
    }


    public Feed(String user, String comment, String rating, String techemail) {
        this.email = email;
        this.comment = comment;
        this.rating = rating;
        this.techemail=techemail;
    }


    public String getTechemail() {
        return techemail;
    }

    public void setTechemail(String techemail) {
        this.techemail = techemail;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

   }
