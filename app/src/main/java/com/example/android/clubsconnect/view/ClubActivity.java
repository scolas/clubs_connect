package com.example.android.clubsconnect.view;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.android.clubsconnect.R;
import com.example.android.clubsconnect.controller.ClubController;
import com.example.android.clubsconnect.model.Club;
import com.example.android.clubsconnect.utilities.NetworkUtils;
import com.example.android.clubsconnect.views.activities.SearchActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

public class ClubActivity extends AppCompatActivity {
    private static final String EXTRA_CLUB_ID = "club_id";
    private TextView mNameTextView;
    private TextView mDetailTextView;
    private TextView mAboutTextView;
    private String mClubId;
    private Club mClub;
    private final FirebaseStorage mFirebaseStorage = FirebaseStorage.getInstance();
    private final FirebaseDatabase mFirebaseDatabase = FirebaseDatabase.getInstance();
    private ImageView mImageView;
    private static final int GITHUB_SEARCH_LOADER = 22;

    private ProgressBar mLoadingIndicator;
    private static final String SEARCH_QUERY_URL_EXTRA = "query";


    ClubController clubController = new ClubController();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //initialize the view
        setContentView(R.layout.club_activity);

        mNameTextView = (TextView) findViewById(R.id.club_name_txt);
        mDetailTextView = (TextView) findViewById(R.id.club_detail_txt);
        mAboutTextView = (TextView) findViewById(R.id.club_about_txt);
        mImageView = findViewById(R.id.club_img);
        mLoadingIndicator = (ProgressBar) findViewById(R.id.pb_loading_indicator);


        //get club id from
        //TODO: replace line below
        mClubId = "1" ;
//        Intent intent = getIntent();
//        Bundle extras = intent.getExtras();
//        if(extras == null || !extras.containsKey(EXTRA_CLUB_ID)){
//            intent = new Intent(this, SearchActivity.class);
//            startActivity(intent);
//            finish();
//        } else {
//            mClubId = extras.getString(EXTRA_CLUB_ID);
//        }

        loadClub();
    }

    private void loadClub() {
        DatabaseReference clubReference = mFirebaseDatabase.getReference("clubs")
                .child(mClubId);
        clubReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Object oMap = dataSnapshot.getValue();
                mClub = Club.fromMap(oMap);
                updateView();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void updateView() {
        mAboutTextView.setText(mClub.getDescription());
        mNameTextView.setText(mClub.getClubTitle());
        StorageReference imageReference = mFirebaseStorage.getReferenceFromUrl(mClub.getImageUrl());
        Glide.with(this)
                .load(imageReference)
                .into(mImageView);
    }


}
