package com.example.android.clubsconnect.views.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.android.clubsconnect.MainActivity;

public class SplashScreenActivity extends AppCompatActivity {
    private static final String TAG ="SpralshScreenActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
