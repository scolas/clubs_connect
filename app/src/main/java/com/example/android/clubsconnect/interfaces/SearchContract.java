package com.example.android.clubsconnect.interfaces;

import com.example.android.clubsconnect.model.Club;

import java.util.List;

/**
 * Created by rakeshpraneeth on 3/17/18.
 */

public interface SearchContract {

    interface SearchView{

        void showProgressbar();

        void hideProgressbar();

        void displaySearchResults(List<Club> clubList);
    }

    interface SearchPresenter{

        void search(String searchQuery);
    }

}
