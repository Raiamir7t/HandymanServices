package com.example.handyman;

import java.io.Serializable;
import java.util.ArrayList;

public class HandyMan implements Serializable {

    ArrayList<String> services;
    private  int handymanId;
    private String name;
    private String email;
    private int contact;
    private double rate;
    private int rating;
    private double latitude;
    private double longitude;



    public HandyMan(String name, double rate, int rating, double latitude, double longitude) {
        this.name = name;
        this.rate = rate;
        this.rating = rating;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public void setServices(ArrayList<String> services) {
        this.services = services;
    }
    public ArrayList<String> getServices() {
        return services;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public double getRate() {
        return rate;
    }

    public int getRating() {
        return rating;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public int getHandymanId() {
        return handymanId;
    }

    public void setHandymanId(int handymanId) {
        this.handymanId = handymanId;
    }
}
