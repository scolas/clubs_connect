package com.example.android.clubsconnect.model;

/**
 * Updated by MaherSoua
 */

public class User {
    private String mUsername;
    private String mPassword;
    private String mEmail;

    public User(String email, String password) {
        this.mPassword = password;
        this.mEmail = email;
    }

    public String getUsername() {
        return mUsername;
    }

    public String getPassword() {
        return mPassword;
    }

    public String getEmail() {
        return mEmail;
    }
}