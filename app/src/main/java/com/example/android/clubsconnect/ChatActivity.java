package com.example.android.clubsconnect;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.android.clubsconnect.model.Message;
import com.example.android.clubsconnect.view.MessageViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.database.SnapshotParser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by ProfessorTaha on 3/3/2018.
 */

public class ChatActivity extends AppCompatActivity implements View.OnClickListener{
    //public static final String MESSAGES = "messages";
    private static final String TAG = "ChatActivity";
    private static final String MESSAGES_CHILD = "messages";
    //ArrayList<Message> mMessages;
    private RecyclerView mChatMessageRecyclerView;
    private Button mSendButton;
    private EditText mMessageEditText;


    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;
    private String mUsername;
    private String mPhotoUrl;
    private DatabaseReference mFirebaseDatabaseReference;
    private FirebaseRecyclerAdapter<Message, MessageViewHolder> mFirebaseAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.chat);
        mChatMessageRecyclerView = findViewById(R.id.recyclerView);
        mSendButton = findViewById(R.id.sendButton);
        mMessageEditText = findViewById(R.id.chatEditText);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();

        if (mFirebaseUser == null) {
            // Not signed in, launch the Sign In activity
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return;
        } else {
            mUsername = mFirebaseUser.getDisplayName();
            if (mFirebaseUser.getPhotoUrl() != null) {
                mPhotoUrl = mFirebaseUser.getPhotoUrl().toString();
            }
        }



//        if(savedInstanceState != null && savedInstanceState.containsKey(MESSAGES)){
//            mMessages = (ArrayList<Message>) savedInstanceState.getSerializable(MESSAGES);
//        } else {
//            mMessages = new ArrayList<>();
//        }

        LinearLayoutManager lm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        lm.setStackFromEnd(true);
        mFirebaseDatabaseReference = FirebaseDatabase.getInstance().getReference();

        SnapshotParser<Message> parser = new SnapshotParser<Message>() {
            @Override
            public Message parseSnapshot(DataSnapshot dataSnapshot) {
                Message Message = dataSnapshot.getValue(Message.class);
                if (Message != null) {
                    Message.setId(dataSnapshot.getKey());
                }
                return Message;
            }
        };

        DatabaseReference messagesRef = mFirebaseDatabaseReference.child(MESSAGES_CHILD);

        FirebaseRecyclerOptions<Message> options =
                new FirebaseRecyclerOptions.Builder<Message>()
                        .setQuery(messagesRef, parser)
                        .build();

        mChatMessageRecyclerView.setLayoutManager(lm);

        mFirebaseAdapter = new FirebaseRecyclerAdapter<Message, MessageViewHolder>(options) {

            @Override
            public MessageViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
                LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
                return new MessageViewHolder(inflater.inflate(R.layout.chat_message_row_self, viewGroup, false));
            }

            @Override
            protected void onBindViewHolder(final MessageViewHolder viewHolder,
                                            int position,
                                            Message message) {

                if (message.getText() != null) {
                    viewHolder.messageTextView.setText(message.getText());
                }

            }
        };
        mChatMessageRecyclerView.setAdapter(mFirebaseAdapter);

        mSendButton.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mFirebaseAdapter.startListening();
    }

    @Override
    protected void onPause() {
        mFirebaseAdapter.stopListening();
        super.onPause();
    }

    @Override
    public void onClick(View v) {
        String messageText = mMessageEditText.getText().toString(); //TODO: internationlization.
        mMessageEditText.setText("");
        Message message = new Message(messageText);
        message.setType(Message.MessageType.FROM_ME);
        mFirebaseDatabaseReference.child(MESSAGES_CHILD).push().setValue(message);
    }
}
