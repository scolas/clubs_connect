package com.example.android.clubsconnect.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.clubsconnect.R;
import com.example.android.clubsconnect.model.Message;
import com.example.android.clubsconnect.view.MessageViewHolder;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by ProfessorTaha on 3/3/2018.
 */

public class MessageAdapter extends RecyclerView.Adapter<MessageViewHolder> {
    public static final int MESSAGE_FROM_GROUP = 1;
    public static final int MESSAGE_FROM_ME = 0;
    private ArrayList<Message> mMessages = new ArrayList<>();
    private Context mContext;

    @Override
    public int getItemViewType(int position) {
        switch (mMessages.get(position).getType()){
            case FROM_ME:
                return MESSAGE_FROM_ME;
            case FROM_GROUP:
                return MESSAGE_FROM_GROUP;
        }
        return -1;
    }

    public MessageAdapter(@NonNull Context context) {
        Objects.requireNonNull(context);
        mContext = context.getApplicationContext();
        String [] messages = {
                "Hi",
                "Hello",
                "Group is here",
                "Let's build this",
                "sldkjfal;skdjfl;ak sjdf l;kasjdfl; kjasdl;kfj ;alskdj f;lkjas dl;kfj ;lasd\n askjdfhk 't 'n sadkfjhkjasdhf \n \n \t \t asdjkfhkjh "
        };
        for(int i =0; i < messages.length; ++i){
            Message m = new Message(messages[i]);
            if(i%2 ==0 )
                m.setType(Message.MessageType.FROM_GROUP);
            else
                m.setType(Message.MessageType.FROM_ME);
            mMessages.add(m);
        }
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = null;
        LayoutInflater li = LayoutInflater.from(mContext);
        switch (viewType){
            case MESSAGE_FROM_GROUP:
                v = li.inflate(R.layout.chat_message_row_group, parent, false);
                break;
            case MESSAGE_FROM_ME:
                v = li.inflate(R.layout.chat_message_row_self, parent, false);
                break;
        }
        MessageViewHolder mv = new MessageViewHolder(v);
        return mv;
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        holder.bindMessage(mMessages.get(position));
    }

    @Override
    public int getItemCount() {
        return mMessages.size();
    }
}
