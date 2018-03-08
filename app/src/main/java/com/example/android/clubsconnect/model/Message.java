package com.example.android.clubsconnect.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by ProfessorTaha on 3/3/2018.
 */

public class Message implements Serializable {
    private Timestamp mTimeSent;
    private String mText;
    private Author mAuthor;
    private Club mClub;
    private int mId;
    private MessageType mType;

    public Timestamp getTimeSent() {
        return mTimeSent;
    }

    public void setTimeSent(Timestamp timeSent) {
        mTimeSent = timeSent;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public Author getAuthor() {
        return mAuthor;
    }

    public void setAuthor(Author author) {
        mAuthor = author;
    }

    public Club getClub() {
        return mClub;
    }

    public void setClub(Club club) {
        mClub = club;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public MessageType getType() {
        return mType;
    }

    public void setType(MessageType type) {
        mType = type;
    }

    public static enum MessageType {
        FROM_ME, FROM_GROUP;
    }
}
