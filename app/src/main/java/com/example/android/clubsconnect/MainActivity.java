package com.example.android.clubsconnect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.android.clubsconnect.model.Club;
import com.example.android.clubsconnect.model.ClubAdmin;

public class MainActivity extends AppCompatActivity {
//comment test
    TextView testTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testTV = (TextView) findViewById(R.id.hello_world);
        Club testClub = testSetUpClub();
        testTV.setText(testClub.toString());

    }

    //sorry I'll learn how to use the unit testing components,
    // but probably after phase I of class is over.

    private Club testSetUpClub(){
        Club newClub = new Club();
        newClub.setAdmin(new ClubAdmin("Peanut"));
        return newClub;
    }
}
