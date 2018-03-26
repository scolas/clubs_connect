package com.example.android.clubsconnect.views.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.android.clubsconnect.LoginActivity;
import com.example.android.clubsconnect.MainActivity;

public class SplashScreenActivity extends AppCompatActivity {

    private final Boolean isLogged = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = null;
        if(isLogged){
            intent = new Intent(this, MainActivity.class);
        } else {
            intent = new Intent(this, LoginActivity.class);
        }
        startActivity(intent);
        finish();
    }
}
