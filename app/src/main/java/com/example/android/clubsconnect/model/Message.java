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

    /**
     * <b>equals()</b>
     * <p>
     *     This method overrides the default equals method. It is used to verify if a message
     *     is the same message as the passed object.
     * </p>
     * @param obj
     *          - Object passed to the method will be compared for equivalency to Message calling
     *          this method.
     * @return
     *          - true if equals, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof  Message)) {
            return false;
        }

        Message other = (Message) obj;

        return other.getTimeSent().equals(this.mTimeSent) &&
                other.getText().equals(this.mText) &&
                other.getAuthor().equals(this.mAuthor) &&
                other.getClub().equals(this.mClub) &&
                other.getId() == this.mId &&
                other.getType().equals(this.mType);
    }

    /**
     * <b>toString()</b>
     * <p>
     *     - This toString should not be used to print the message. It returns a formatted
     *      string calling the toString of each variable in the Message object.
     * </p>
     * @return
     *     - String dump of all member variables.
     */
    @Override
    public String toString() {
        return "Text content: " + mText     +
                "\nID: "        + mId       +
                "\nClub: "      + mClub     +
                "\nMsg Type: "  + mType     +
                "\nAuthor: "    + mAuthor   +
                "\nTimestamp"   + mTimeSent;
    }
}
