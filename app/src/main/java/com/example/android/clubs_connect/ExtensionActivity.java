package com.example.android.clubs_connect;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by aaron on 3/3/2018.
 */

public class ExtensionActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    private AwesomeView mAwesomeView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

    }
}
