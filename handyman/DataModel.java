package com.example.handyman;


public class DataModel {
    private String serviceName;
    private String date;
    private String time;

    public DataModel(String serviceName, String date, String time) {
        this.serviceName = serviceName;
        this.date = date;
        this.time = time;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}

