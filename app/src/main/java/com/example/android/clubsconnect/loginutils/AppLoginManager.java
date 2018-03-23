package com.example.android.clubsconnect.loginutils;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.example.android.clubsconnect.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.content.ContentValues.TAG;

/**
 * Created by mahersoua on 21/03/2018.
 */

public class AppLoginManager {

    private static final FirebaseAuth mAuth = FirebaseAuth.getInstance();

    public static void userLogin(final ILoginStatus context, User user){
        mAuth.signInWithEmailAndPassword(user.getEmail(), user.getPassword())
                .addOnCompleteListener((Activity) context, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            context.onLoginSuccess(mAuth.getCurrentUser());
                        } else {
                            context.onLoginFailed(task.getException());
                        }
                    }
                });

    }

    public static void userRegister(final ILoginStatus context, User user){
        mAuth.createUserWithEmailAndPassword(user.getEmail(), user.getPassword())
                .addOnCompleteListener((Activity) context, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            context.onRegisterSuccess(mAuth.getCurrentUser());
                        } else {
                            context.onRegisterFailed(task.getException());
                        }
                    }
                });
    }

    public interface ILoginStatus {
        void onLoginSuccess(FirebaseUser user);
        void onLoginFailed(Exception error);
        void onRegisterSuccess(FirebaseUser user);
        void onRegisterFailed(Exception error);
    }
}