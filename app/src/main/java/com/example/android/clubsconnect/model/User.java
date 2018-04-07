package com.example.android.clubsconnect.model;

import android.support.annotation.NonNull;

import com.example.android.clubsconnect.interfaces.Consumer;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * Updated by MaherSoua
 */

public class User {
    private static final String  KEY_IMAGE_URL = "image_url";
    private static final String  KEY_FRIENDLY_NAME = "friendly_name";
    private static final String  KEY_MEMBER_CLUB_IDS = "member_club_ids";
    private static final String  KEY_FIRST_NAME = "first_name";
    private static final String  KEY_LAST_NAME = "last_name";
    private static final String  KEY_ADMIN_CLUB_IDS = "admin_club_ids";
    private static final String  KEY_ROLE = "role";

    private static final String ROLE_CLUB_MEMBER = "club_member";

    private String mUsername;
    private String mPassword;
    private String mEmail;
    private String mId;
    private String mImageUrl;
    private String mFriendlyName;
    private LinkedList<String> mMemberClubIds;
    private String mFirstName;
    private String mLastName;
    private LinkedList<String> mAdminClubIds;
    private String mRole;

    public User(){}
    public User(FirebaseUser user){
        setId(user.getUid());
        setFriendlyName(user.getDisplayName());
        if(user.getPhotoUrl() != null)
            setImageUrl(user.getPhotoUrl().toString());
        setRole(ROLE_CLUB_MEMBER);
    }
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

    public String getId() {
        return mId;
    }
    public void setId(String id){
        mId = id;
    }

    public static User fromMap(@NonNull Object oMap) {
        Objects.requireNonNull(oMap);
        if (!(oMap instanceof Map)) {
            throw new IllegalArgumentException("Message.fromMap requires a map object");
        }
        final User user = new User();
        Map<String, Object> map = (Map<String, Object>) oMap;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object oValue = entry.getValue();
            switch (key) {
                case KEY_IMAGE_URL:
                    user.setImageUrl((String) oValue);
                    break;
                case KEY_FRIENDLY_NAME:
                    user.setFriendlyName((String) oValue);
                    break;
                case KEY_MEMBER_CLUB_IDS:
                    user.setMemberClubIds(new LinkedList<String>((List<String>) oValue));
                    break;
                case KEY_FIRST_NAME:
                    user.setFirstName((String) oValue);
                    break;
                case KEY_LAST_NAME:
                    user.setLastName((String) oValue);
                    break;
                case KEY_ADMIN_CLUB_IDS:
                    user.setAdminClubIds(new LinkedList<String>((List<String>) oValue));
                    break;
                case KEY_ROLE:
                    user.setRole((String) oValue);
                    break;
            }
        }
        return user;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new TreeMap<>();
        map.put(KEY_IMAGE_URL, getImageUrl());
        map.put(KEY_FRIENDLY_NAME, getFriendlyName());
        map.put(KEY_MEMBER_CLUB_IDS, getMemberClubIds());
        map.put(KEY_FIRST_NAME, getFirstName());
        map.put(KEY_LAST_NAME, getLastName());
        map.put(KEY_ADMIN_CLUB_IDS, getAdminClubIds());
        map.put(KEY_ROLE, getRole());
        return map;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    public void setFriendlyName(String friendlyName) {
        mFriendlyName = friendlyName;
    }

    public void setMemberClubIds(LinkedList<String> memberClubIds) {
        mMemberClubIds = memberClubIds;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public void setAdminClubIds(LinkedList<String> adminClubIds) {
        mAdminClubIds = adminClubIds;
    }

    public void setRole(String role) {
        mRole = role;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public String getFriendlyName() {
        return mFriendlyName;
    }

    public LinkedList<String> getMemberClubIds() {
        return mMemberClubIds;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public LinkedList<String> getAdminClubIds() {
        return mAdminClubIds;
    }

    public String getRole() {
        return mRole;
    }

    public static void findById(String uId, final Consumer<User> userConsumer) {
        DatabaseReference fuser = FirebaseDatabase.getInstance().getReference("users")
                .child(uId);
        fuser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User user =  fromMap(dataSnapshot.getValue());
                userConsumer.accept(user);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}