package com.example.android.clubsconnect.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.clubsconnect.R;
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_search_item,parent,false);
        return new SearchViewHolder(view);
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

        TextView clubTitle, clubDescription;

        public SearchViewHolder(View itemView) {
            super(itemView);

            clubTitle = itemView.findViewById(R.id.clubName);
            clubDescription = itemView.findViewById(R.id.clubDescription);
        }

        public void bind(int position){
            clubTitle.setText(mClubList.get(position).getClubTitle());
            clubDescription.setText(mClubList.get(position).getmClubDetails());

        }
    }
}
