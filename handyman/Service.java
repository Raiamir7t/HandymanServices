package com.example.handyman;

public class Service {

    private int imageResId; // Assuming you'll use resource IDs for images
    private String name;


    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Service( String name,int imageResId) {
        this.imageResId = imageResId;
        this.name = name;
    }


}
