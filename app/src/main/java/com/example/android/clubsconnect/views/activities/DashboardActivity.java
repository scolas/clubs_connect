package com.example.android.clubsconnect.views.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.android.clubsconnect.ChatActivity;
import com.example.android.clubsconnect.R;
import com.example.android.clubsconnect.databinding.ActivityDashboardBinding;

public class DashboardActivity extends AppCompatActivity {

    ActivityDashboardBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_dashboard);
        setTitle("Dashboard");

        binding.searchForClubBtn.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(),SearchActivity.class)));

        binding.chatInClubBtn.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), ChatActivity.class)));

    }
}
