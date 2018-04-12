package com.example.android.clubsconnect.adapters;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.android.clubsconnect.R;
import com.example.android.clubsconnect.databinding.CustomSearchItemBinding;
import com.example.android.clubsconnect.model.Club;

import java.util.List;

/**
 * Created by rakeshpraneeth on 3/17/18.
 */

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder>{

    private List<Club> mClubList;
    
    public SearchAdapter(){

    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CustomSearchItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.custom_search_item,parent,false);
        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_search_item,parent,false);
        return new SearchViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mClubList.size();
    }

    public void setClubData(List<Club> mClubList){
        this.mClubList = mClubList;
        notifyDataSetChanged();
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder{

        CustomSearchItemBinding binding;

        public SearchViewHolder(CustomSearchItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(int position){

            binding.clubName.setText(mClubList.get(position).getClubTitle());
            binding.clubDescription.setText(mClubList.get(position).getmClubDetails());

        }
    }
}
