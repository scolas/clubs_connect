package com.example.android.clubsconnect;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.android.clubsconnect.controller.MessageAdapter;

/**
 * Created by ProfessorTaha on 3/3/2018.
 */

public class ChatActivity extends AppCompatActivity implements View.OnClickListener{
    //public static final String MESSAGES = "messages";
    private static final String TAG = "ChatActivity";
    //ArrayList<Message> mMessages;
    private RecyclerView mChatMessageRecyclerView;
    private Button mSendButton;
    private EditText mMessageEditText;


    private MessageAdapter mMessageAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.chat);
        mChatMessageRecyclerView = findViewById(R.id.recyclerView);
        mSendButton = findViewById(R.id.sendButton);
        mMessageEditText = findViewById(R.id.chatEditText);
        mMessageAdapter = new MessageAdapter(this);

//        if(savedInstanceState != null && savedInstanceState.containsKey(MESSAGES)){
//            mMessages = (ArrayList<Message>) savedInstanceState.getSerializable(MESSAGES);
//        } else {
//            mMessages = new ArrayList<>();
//        }

        RecyclerView.LayoutManager lm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mChatMessageRecyclerView.setLayoutManager(lm);
        mChatMessageRecyclerView.setAdapter(mMessageAdapter);

        mSendButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String message = mMessageEditText.getText().toString(); //TODO: internationlization.
        mMessageEditText.setText("");

    }
}
