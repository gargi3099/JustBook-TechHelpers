package com.example.urbanclone_techhelpers;

public class feedbackdata {
    private String rating;
    private String comment;
    private String email;
    private String techemail;
    public feedbackdata(String rating, String comment, String email,String techemail) {
        this.rating = rating;
        this.comment = comment;
        this.email=email;
        this.techemail=techemail;
    }

    public feedbackdata() {
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


    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
