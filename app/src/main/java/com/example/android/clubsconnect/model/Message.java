package com.example.android.clubsconnect.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * <i><b>Message</b></i>
 * <p>
 *     This Model Class is used to represent a single message in our application.
 *     Messages are used for the chat section of the application.
 * </p>
 *
 */

public class Message implements Serializable {
    //MEMBER VARIABLES

    private Timestamp mTimeSent;
    private String mText;
    private Author mAuthor;
    private Club mClub;
    private String mId;
    private MessageType mType;

    /**
     * <b>Default Constructor</b>
     * <p>
     * This constructor should be used for debugging and testing purposes.
     * <p>
     * The text is set to a default message, and the id is set to -1.
     * </p>
     * </p>
     */
    public Message() {
        this.mText = "This is a default message created by the default constructor";
        this.mId = null; //-1 signals was not created in the DB, and is invalid
    }

    public Message(String message) {
        mText = message;
    }

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

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    // CONSTRUCTORS

    public MessageType getType() {
        return mType;
    }

    public void setType(MessageType type) {
        mType = type;
    }

    /**
     * <b>equals()</b>
     * <p>
     *     This method overrides the default equals method. It is used to verify if a Message
     *     contains identical data compared to a passed object.
     * </p>
     * @param obj
     *          - Object passed to the method will be compared with respect to equivalency
     *          to the Message calling this method.
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
     *      string calling the toString of each member variable in the Message object.
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

    public static enum MessageType {
        FROM_ME, FROM_GROUP;
    }
}
