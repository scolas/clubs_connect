package com.example.android.clubs_connect.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.android.clubs_connect.R;
import com.example.android.clubs_connect.model.Message;

/**
 * Created by ProfessorTaha on 3/3/2018.
 */

public class MessageViewHolder extends RecyclerView.ViewHolder {
    TextView mTextView;

    public MessageViewHolder(View itemView) {
        super(itemView);
        mTextView = itemView.findViewById(R.id.messageTextView);
    }

    public void bindMessage(Message message) {
        mTextView.setText(message.getText());
    }
}
