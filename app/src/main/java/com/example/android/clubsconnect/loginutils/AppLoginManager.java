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

    public static void userLogin(final Activity activity, User user){
        mAuth.signInWithEmailAndPassword(user.getEmail(), user.getPassword())
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            ((ILoginStatus)activity).onLoginSuccess(mAuth.getCurrentUser());
                        } else {
                            ((ILoginStatus)activity).onLoginFailed(task.getException());
                        }
                    }
                });

    }

    public static void userRegister(final Activity activity, User user){
        mAuth.createUserWithEmailAndPassword(user.getEmail(), user.getPassword())
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            ((ILoginStatus)activity).onRegisterSuccess(mAuth.getCurrentUser());
                        } else {
                            ((ILoginStatus)activity).onRegisterFailed(task.getException());
                            Toast.makeText(activity, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
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