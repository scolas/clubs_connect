package com.example.android.clubsconnect;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.android.clubsconnect.databinding.ActivityLoginBinding;
import com.example.android.clubsconnect.loginutils.AppLoginManager;
import com.example.android.clubsconnect.model.User;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity implements AppLoginManager.ILoginStatus {

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        binding.submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });

        binding.registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });

    }

    private void loginUser(){
        AppLoginManager.userLogin(LoginActivity.this,
                new User(binding.userName.getText().toString(), binding.password.getText().toString())
        );
    }

    private void registerUser(){
        AppLoginManager.userRegister(LoginActivity.this,
                new User(binding.userName.getText().toString(), binding.password.getText().toString())
        );
    }

    @Override
    public void onLoginSuccess(FirebaseUser user) {
        Toast.makeText(LoginActivity.this, "Authentication success ", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(LoginActivity.this, ChatActivity.class));
    }

    @Override
    public void onLoginFailed(Exception error) {
        Toast.makeText(LoginActivity.this, "Authentication failed "+error.getMessage(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onRegisterSuccess(FirebaseUser user) {
        Toast.makeText(LoginActivity.this, "Registration success ", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(LoginActivity.this, ChatActivity.class));
    }

    @Override
    public void onRegisterFailed(Exception error) {
        Toast.makeText(LoginActivity.this, "Registration failed "+error.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
