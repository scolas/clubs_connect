package com.example.android.clubsconnect.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.clubsconnect.R;
import com.example.android.clubsconnect.controller.ClubController;

public class ClubActivity extends AppCompatActivity {
    TextView mNameTextView;
    TextView mDetailTextView;
    TextView mAboutTextView;
    ImageView mImage;
    ClubController clubController = new ClubController();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);

        mNameTextView = (TextView) findViewById(R.id.club_name_txt);
        mDetailTextView = (TextView) findViewById(R.id.club_detail_txt);
        mAboutTextView = (TextView) findViewById(R.id.club_about_txt);

        String about = clubController.getAbout();
        mAboutTextView.setText(about);
    }
}
