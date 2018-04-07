package com.example.android.clubsconnect.model;

import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Map;
import java.util.Objects;

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

    private static final String KEY_TEXT = "message_text";
    private static final String KEY_AUTHOR_ID = "author_id";
    private static final String KEY_CLUB_ID = "club_id";
    private static final String KEY_TIME = "message_time_sent";
    private Timestamp mTimeSent;
    private String mText;
    private User mAuthor;
    private Club mClub;
    private String mId;
    private MessageType mType;
    private String mClubId;

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

    /**
     * Generate a Message from a Map object returned from firebase's DataSnapshot.getValue();
     */
    public static Message fromMap(@NonNull Object oMap) {
        Objects.requireNonNull(oMap);
        if (!(oMap instanceof Map)) {
            throw new IllegalArgumentException("Message.fromMap requires a map object");
        }
        final Message message = new Message();
        Map<String, Object> map = (Map<String, Object>) oMap;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object oValue = entry.getValue();
            switch (key) {
                case KEY_TEXT:
                    message.setText((String) oValue);
                    break;
                case KEY_AUTHOR_ID:
                    User.findById((String) oValue, message::setAuthor);
                    break;
                case KEY_CLUB_ID:
                    message.setClubId((String) oValue);
                    break;
                case KEY_TIME:
                    message.setTimeSent((Timestamp.valueOf((String) oValue)));
                    break;
            }
        }
        return message;
    }

    public Map<String, Object> toMap() {
        final Map<String, Object> map = new ArrayMap<>(4);
        if (mAuthor != null) {
            map.put(KEY_AUTHOR_ID, mAuthor.getId());
        }
        if (mClub != null) {
            map.put(KEY_CLUB_ID, mClub.getId());
        }
        if (mText != null) {
            map.put(KEY_TEXT, mText);
        }
        if (mTimeSent != null) {
            map.put(KEY_TIME, mTimeSent.toString());
        }
        return map;
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

    public User getAuthor() {
        return mAuthor;
    }

    public void setAuthor(User author) {
        mAuthor = author;
    }

    public String getClubId() {
        return mClubId;
    }

    public void setClubId(String clubId) {
        mClubId = clubId;
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
                other.getClubId().equals(this.mClubId) &&
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
