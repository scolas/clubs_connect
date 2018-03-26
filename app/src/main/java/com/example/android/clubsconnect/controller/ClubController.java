package com.example.android.clubsconnect.controller;

import android.os.AsyncTask;
import android.widget.ProgressBar;

import com.example.android.clubsconnect.utilities.NetworkUtils;

import java.io.IOException;
import java.net.URL;

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

    public ClubController(){
        makeClubProfileQuery("map");
    }

    private void makeClubProfileQuery(String clubId){
        String clubQuery = clubId.toString();
        URL clubSearchUrl = NetworkUtils.buildUrl(clubQuery);
        new ClubQueryTask().execute(clubSearchUrl);

    }

    public class ClubQueryTask extends AsyncTask<URL, Void, String>{


        @Override
        protected String doInBackground(URL... params) {
            URL searchUrl = params[0];
            String clubSearchResults = null;

            try{
                clubSearchResults = NetworkUtils.getResponseFromHttpUrl(searchUrl);
            } catch (IOException e){
                e.printStackTrace();
            }
            return clubSearchResults;
        }

        @Override
        protected void onPostExecute(String clubSearchResults) {
            if(clubSearchResults != null && !clubSearchResults.equals("")){
                setDetails(clubSearchResults);
            }else{
                setDetails("not working");
            }
        }
    }
}
