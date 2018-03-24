package com.example.android.clubsconnect.controller;

/**
 * Created by scott on 3/23/18.
 */

public class ClubController {

    private String About;
    private String Details;
    private String Name;


    public String getAbout() {
        return "This is about from controller";
    }

    public void setAbout(String about) {
        About = about;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
