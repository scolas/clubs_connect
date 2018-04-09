package com.example.android.clubsconnect.view;

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

import com.example.android.clubsconnect.R;
import com.example.android.clubsconnect.controller.ClubController;
import com.example.android.clubsconnect.utilities.NetworkUtils;

import java.io.IOException;
import java.net.URL;

public class ClubActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {
    TextView mNameTextView;
    TextView mDetailTextView;
    TextView mAboutTextView;
    ImageView mImage;
    private static final int GITHUB_SEARCH_LOADER = 22;

    private ProgressBar mLoadingIndicator;
    private static final String SEARCH_QUERY_URL_EXTRA = "query";


    ClubController clubController = new ClubController();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.club_activity);

        mNameTextView = (TextView) findViewById(R.id.club_name_txt);
        mDetailTextView = (TextView) findViewById(R.id.club_detail_txt);
        mAboutTextView = (TextView) findViewById(R.id.club_about_txt);
        mLoadingIndicator = (ProgressBar) findViewById(R.id.pb_loading_indicator);

        String about = clubController.getAbout();
        mAboutTextView.setText(about);

        Bundle queryBundle = new Bundle();
        queryBundle.putString(SEARCH_QUERY_URL_EXTRA, " ");

        LoaderManager loaderManager = getSupportLoaderManager();
        Loader<String> githubSearchLoader = loaderManager.getLoader(GITHUB_SEARCH_LOADER);
        if (githubSearchLoader == null) {
            loaderManager.initLoader(GITHUB_SEARCH_LOADER, queryBundle, this);
        } else {
            loaderManager.restartLoader(GITHUB_SEARCH_LOADER, queryBundle, this);
        }

    }


    @Override
    public Loader<String> onCreateLoader(int id, final Bundle args) {
        return new AsyncTaskLoader<String>(this) {
            @Override
            protected void onStartLoading() {
                if(args == null){
                    return;
                }

                mLoadingIndicator.setVisibility(View.VISIBLE);

                forceLoad();
            }

            @Override
            public String loadInBackground() {
                try {
                    return "Next Meeting 05/01/2018";
                }catch (Exception e){
                    e.printStackTrace();
                    return null;
                }

            }
        };
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String data) {
        mLoadingIndicator.setVisibility(View.INVISIBLE);
        if (null == data) {

        } else {
            mDetailTextView.setText(data);
            mNameTextView.setText("Cooking Club");
            mAboutTextView.setText("We invite you to join the (free!) ChopChop Cooking Club and pledge to cook dinner together once a month. Each month, you’ll get a delicious new recipe in your inbox. We’ll all be making the same recipe that month, learning different essential cooking skills along the way. " +
                    "Each challenge will also come with how-tos, shopping and storage tips, fun activities, and conversation starters.");

        }

    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }






}
