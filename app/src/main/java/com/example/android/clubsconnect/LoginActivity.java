package com.example.android.clubsconnect;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.android.clubsconnect.databinding.ActivityLoginBinding;
import com.example.android.clubsconnect.loginutils.AppLoginManager;
import com.example.android.clubsconnect.model.User;
import com.example.android.clubsconnect.views.activities.DashboardActivity;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
        startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
    }

    @Override
    public void onLoginFailed(Exception error) {
        Toast.makeText(LoginActivity.this, "Authentication failed "+error.getMessage(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onRegisterSuccess(FirebaseUser fire_user) {
        Toast.makeText(LoginActivity.this, "Registration success ", Toast.LENGTH_SHORT).show();
        //we need to save the user to our users table now.
        String uid = fire_user.getUid();
        User user = new User(fire_user);
        DatabaseReference usersDb = FirebaseDatabase.getInstance().getReference("users");
        usersDb.child(uid).setValue(user.toMap());
        startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
    }

    @Override
    public void onRegisterFailed(Exception error) {
        Toast.makeText(LoginActivity.this, "Registration failed "+error.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
