package com.example.android.clubsconnect.views.fragments;


import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.android.clubsconnect.R;
import com.example.android.clubsconnect.adapters.SearchAdapter;
import com.example.android.clubsconnect.databinding.FragmentSearchBinding;
import com.example.android.clubsconnect.interfaces.SearchContract;
import com.example.android.clubsconnect.model.Club;
import com.example.android.clubsconnect.presenters.SearchPresenterImpl;
import com.example.android.clubsconnect.view.ClubActivity;

import java.util.List;

public class SearchFragment extends Fragment implements SearchContract.SearchView, View.OnClickListener, SearchAdapter.onSearchItemClickListener{

    FragmentSearchBinding binding;

    SearchContract.SearchPresenter presenter;

    SearchAdapter searchAdapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()),R.layout.fragment_search,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter = new SearchPresenterImpl(this);
        initializeListeners();
    }

    private void initializeListeners(){
        binding.clubSearchBtn.setOnClickListener(this);
    }

    public static SearchFragment newInstance() {
        
        Bundle args = new Bundle();
        
        SearchFragment fragment = new SearchFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void showProgressbar() {
        binding.searchProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressbar() {
        binding.searchProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showSearchMsg() {
        binding.searchMsgTV.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideSearchMsg() {
        binding.searchMsgTV.setVisibility(View.GONE);
    }

    @Override
    public void displaySearchResults(List<Club> clubList) {

        layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);

        binding.searchRV.setLayoutManager(layoutManager);
        binding.searchRV.setHasFixedSize(true);

        if(searchAdapter == null) {
            searchAdapter = new SearchAdapter(this);
        }
        searchAdapter.setClubData(clubList);

        binding.searchRV.setAdapter(searchAdapter);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.clubSearchBtn:
                String searchValue = binding.searchET.getText().toString();

                if(!searchValue.isEmpty()) {
                    // If search value is not empty.
                    presenter.search(searchValue);
                }else{
                    Toast.makeText(getContext(),getString(R.string.enter_a_club_name),Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public void onSearchItemClicked() {
        startActivity(new Intent(getContext(), ClubActivity.class));
    }
}
