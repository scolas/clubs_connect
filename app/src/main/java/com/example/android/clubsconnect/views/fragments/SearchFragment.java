package com.example.android.clubsconnect.views.fragments;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.clubsconnect.R;
import com.example.android.clubsconnect.controller.SearchAdapter;
import com.example.android.clubsconnect.databinding.FragmentSearchBinding;
import com.example.android.clubsconnect.interfaces.SearchContract;
import com.example.android.clubsconnect.model.Club;
import com.example.android.clubsconnect.presenters.SearchPresenterImpl;

import java.util.List;

public class SearchFragment extends Fragment implements SearchContract.SearchView{

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
        searchETListener();
    }

    private void searchETListener(){

        binding.searchET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                // TODO: 3/17/18 check in future with team
                if(!editable.toString().isEmpty() && editable.toString().length() >3){
                    presenter.search(editable.toString());
                }

            }
        });
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
    public void displaySearchResults(List<Club> clubList) {

        layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);

        binding.searchRV.setLayoutManager(layoutManager);
        binding.searchRV.setHasFixedSize(true);

        if(searchAdapter == null) {
            searchAdapter = new SearchAdapter();
        }
        searchAdapter.setClubData(clubList);

        binding.searchRV.setAdapter(searchAdapter);

    }
}
