package com.example.android.clubs_connect.controller;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.android.clubs_connect.model.Message;
import com.example.android.clubs_connect.view.MessageViewHolder;

import java.util.ArrayList;

/**
 * Created by ProfessorTaha on 3/3/2018.
 */

public class MessageAdapter extends RecyclerView.Adapter<MessageViewHolder> {
    private ArrayList<Message> mMessages;


    public MessageAdapter(Context context) {

    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = System.
        return new MessageViewHolder();
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return return mMessages.size();
    }
}
