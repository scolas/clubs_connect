package com.example.android.clubsconnect.utilities;

import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by scott on 3/25/18.
 */

public class NetworkUtils {

    final static String CLUB_PROFILE_URL = "https://api.github.com/search/repositories";
    final static String PARAM_QUERY = "q";



    public static URL buildUrl(String getClubId){
        Uri builtUri = Uri.parse(CLUB_PROFILE_URL).buildUpon()
                .appendQueryParameter(PARAM_QUERY, getClubId)
                .build();

        URL url = null;
        try {
            url = new URL(builtUri.toString());
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        return url;
    }


    public static String getResponseFromHttpUrl(URL url) throws IOException{
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();
            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");
            boolean hasInput = scanner.hasNext();

            if (hasInput){
                return scanner.next();
            }else{
                return null;
            }
        }finally {
            urlConnection.disconnect();

        }
    }
}
