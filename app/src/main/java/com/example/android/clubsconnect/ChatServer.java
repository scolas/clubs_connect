package com.example.android.clubsconnect;

import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.android.clubsconnect.model.Club;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Future;

public class ChatServer {
    private static ChatServer sDefaultInstance;
    private String mUrl;
    private ChatServer(){

    }
    synchronized public static ChatServer getDefaultServer(){
        if(Objects.isNull(sDefaultInstance)) {
            sDefaultInstance = new ChatServer();
            //Todo: implement
        }
        return sDefaultInstance;
    }

    /**
     * This Method will return a Future.
     * @param message
     */
    public Future<Void> sendMessageAsync(Message message){
        //save message to local db,
        //send message to cloud
        return null;
    }
    public Future<List<Message>> getMessagesAsync(@NonNull Club club,@NonNull Timestamp from, @Nullable Timestamp to){
        //get messages from the db
        //update missing ones from the server. 
        return null;
    }

    public static class Builder{

        public ChatServer build(){
            return null;
        }
    }
}
