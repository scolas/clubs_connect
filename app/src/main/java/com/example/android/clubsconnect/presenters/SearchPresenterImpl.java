package com.example.android.clubsconnect.presenters;

import com.example.android.clubsconnect.interfaces.SearchContract;
import com.example.android.clubsconnect.model.Club;

import java.util.ArrayList;

/**
 * Created by rakeshpraneeth on 3/17/18.
 */

public class SearchPresenterImpl implements SearchContract.SearchPresenter {

    SearchContract.SearchView searchView;

    public SearchPresenterImpl(SearchContract.SearchView searchView){
        this.searchView = searchView;

    }
    @Override
    public void search(String searchQuery) {

        // TODO: 3/17/18 Modify to real network call.

        if(searchView !=null){

            searchView.hideSearchMsg();
            searchView.showProgressbar();

            ArrayList<Club> list = new ArrayList();
            for(int i=0;i<searchQuery.length();i++){
                list.add(getClub(i));
            }

            searchView.hideProgressbar();
            searchView.displaySearchResults(list);
        }
    }

    private Club getClub(int i){
        Club club  = new Club();
        club.setClubTitle("Club Title Result : "+i);
        club.setmClubDetails("Club details value :"+i);

        return club;
    }
}
