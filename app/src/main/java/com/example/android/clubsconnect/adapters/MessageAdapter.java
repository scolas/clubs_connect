package com.example.android.clubsconnect.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.android.clubsconnect.model.Message;
import com.example.android.clubsconnect.view.MessageViewHolder;

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
       // LayoutInflater li = System.
       // return new MessageViewHolder();
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mMessages.size();
    }
}
