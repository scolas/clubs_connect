package com.example.android.clubsconnect.view;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.android.clubsconnect.R;
import com.example.android.clubsconnect.controller.ClubController;
import com.example.android.clubsconnect.utilities.NetworkUtils;

import java.io.IOException;
import java.net.URL;

public class ClubActivity extends AppCompatActivity {
    TextView mNameTextView;
    TextView mDetailTextView;
    TextView mAboutTextView;
    ImageView mImage;

    private ProgressBar mLoadingIndicator;


    ClubController clubController = new ClubController();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);

        mNameTextView = (TextView) findViewById(R.id.club_name_txt);
        mDetailTextView = (TextView) findViewById(R.id.club_detail_txt);
        mAboutTextView = (TextView) findViewById(R.id.club_about_txt);
        mLoadingIndicator = (ProgressBar) findViewById(R.id.pb_loading_indicator);

        String about = clubController.getAbout();
        mAboutTextView.setText(about);
       // mDetailTextView.setText(clubController.getDetails());
    }





    private void makeClubProfileQuery(String clubId){
        String clubQuery = clubId.toString();
        URL clubSearchUrl = NetworkUtils.buildUrl(clubQuery);
        new ClubQueryTask().execute(clubSearchUrl);

    }

    public class ClubQueryTask extends AsyncTask<URL, Void, String> {


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
               // setDetails(clubSearchResults);
            }else{
                //setDetails("not working");
            }
        }
    }
}
