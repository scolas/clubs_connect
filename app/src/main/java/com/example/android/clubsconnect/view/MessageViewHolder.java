package com.example.android.clubsconnect.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.android.clubsconnect.R;
import com.example.android.clubsconnect.model.Message;

/**
 * Created by ProfessorTaha on 3/3/2018.
 */

public class MessageViewHolder extends RecyclerView.ViewHolder {
    public TextView messageTextView;

    public MessageViewHolder(View itemView) {
        super(itemView);
        messageTextView = itemView.findViewById(R.id.messageTextView);
    }

    public void bindMessage(Message message) {
        messageTextView.setText(message.getText());
    }
}
