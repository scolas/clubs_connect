package com.example.android.clubsconnect.views.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.android.clubsconnect.R;
import com.example.android.clubsconnect.views.fragments.SearchFragment;

public class SearchActivity extends AppCompatActivity {
    private static final String TAG = "SearchActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_single_container);

        loadFragment(SearchFragment.newInstance());
    }

    private void loadFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragmentContainer,fragment)
                .commit();
    }
}
