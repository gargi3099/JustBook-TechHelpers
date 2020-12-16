package com.example.urbanclone_techhelpers;

public class Model {
    String name,email,address;
    String image;
    Float avgrating;

    public Model(String name, String email, String address, Float avgrating, String image) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.avgrating = avgrating;
        this.image=image;
    }

    public Model() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getAvgrating() {
        return avgrating;
    }

    public void setAvgrating(Float avgrating) {
        this.avgrating = avgrating;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
