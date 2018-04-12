package com.example.android.clubsconnect.presenters;

import com.example.android.clubsconnect.interfaces.SearchContract;
import com.example.android.clubsconnect.model.Club;

import java.util.ArrayList;
import java.util.List;

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

            searchView.hideProgressbar();
            searchView.displaySearchResults(getClubsList());
        }
    }

    private List<Club> getClubsList() {
        ArrayList<Club> clubs = new ArrayList<>();
        clubs.add(new Club("Android Development", "We be expert in the Android world."));
        clubs.add(new Club("iOS Development", "We discuss latest technologies going on in the iOS world."));
        clubs.add(new Club("Web Development", "We discuss about web development."));
        clubs.add(new Club("Soccer", "Want to play soccer every week?. "));
        clubs.add(new Club("Learn coding", "Join in our group sessions to learn coding "));
        clubs.add(new Club("Motivation", "We motivate you everyday"));
        return clubs;
    }

}
