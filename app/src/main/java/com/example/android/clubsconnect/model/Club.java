package com.example.android.clubsconnect.model;

import android.location.Location;
import android.media.Image;
import android.support.v4.util.ArrayMap;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * <i><b>Club</b></i>
 * <p>
 *     This Model Class is used to represent a single Club in our application.
 * </p>
 *
 */

public class Club {
    // MEMBER VARIABLES
    private static final String KEY_NAME = "name";
    private static final String KEY_COLLEGE_ID = "college_id";
    private static final String KEY_CITY = "city";
    private static final String KEY_STATE = "state";
    private static final String KEY_MEMBER_IDS = "member_ids";
    private static final String KEY_ADMIN_IDS = "admin_ids";
    private static final String KEY_IMAGE_URL = "image_url";
    private static final String KEY_DESCRIPTION = "description";
    //TODO: do we need more?


    private String mClubTitle;
    private String mCollegeId;
    private String mId;
    //private ArrayList<Admin> mAdmin;
    //private ArrayList<Users> mUsers;
    private String mCity;
    private String mState;
    private Location mClubLocation;
    private Image mClubImage;
    private String mClubDetails;
    private Event mNextEvent;
    private String mMembersCount;
    private String mImageUrl;
    private LinkedList<String> mAdminIds;
    private LinkedList<String> mMemberIds;
    private String mDescription;

    // GETTERS
    //Test
//test1
    public static Club fromMap(Object oMap) {
        Objects.requireNonNull(oMap);
        if (!(oMap instanceof Map)) {
            throw new IllegalArgumentException("Message.fromMap requires a map object");
        }
        final Club club = new Club();
        Map<String, Object> map = (Map<String, Object>) oMap;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object oValue = entry.getValue();
            switch (key) {
                case KEY_IMAGE_URL:
                    club.setImageUrl((String) oValue);
                    break;
                case KEY_CITY:
                    club.setCity((String) oValue);
                    break;
                case KEY_ADMIN_IDS:
                    club.setAdminIds(new LinkedList<String>((List<String>) oValue));
                    break;
                case KEY_NAME:
                    club.setClubTitle((String) oValue);
                    break;
                case KEY_STATE:
                    club.setState((String) oValue);
                    break;
                case KEY_MEMBER_IDS:
                    club.setMemberIds(new LinkedList<String>((List<String>) oValue));
                    break;
                case KEY_DESCRIPTION:
                    club.setDescription((String) oValue);
                    break;
                case KEY_COLLEGE_ID:
                    club.setCollegeId((String) oValue);
                    break;
            }
        }
        return club;

    }

    public Map<String, Object> toMap() {
        final ArrayMap<String, Object> map = new ArrayMap<>();
        map.put(KEY_NAME, getClubTitle());
        map.put(KEY_COLLEGE_ID, getCollegeId());
        map.put(KEY_CITY, getCity());
        map.put(KEY_STATE, getState());
        map.put(KEY_MEMBER_IDS, getMemberIds());
        map.put(KEY_ADMIN_IDS, getAdminIds());
        map.put(KEY_IMAGE_URL, getImageUrl());
        map.put(KEY_DESCRIPTION, getDescription());
        return map;
    }
    public void setClubTitle(String clubTitle) { this.mClubTitle = clubTitle; }


    // CONSTRUCTORS

    /**
     * <b>Default Constructor</b>
     * <p>
     *     Used for debugging and quick testing purposes.
     * </p>
     */
    public Club() {
        this.mClubTitle = "This is not a real club";
        this.mId = null;
    }

    // SETTERS

    public String getClubTitle() { return this.mClubTitle; }


    //public Author getAdmin() {return this.mAdmin; }
    public void setmClubDetails(String mClubDetails) {
        this.mClubDetails = mClubDetails;
    }

    public String getClubDetails() {
        return mClubDetails;
    }

    /**
     * <b>toString()</b>
     * <p>
     *     - This toString should not be used to print the Club to the user. It returns a formatted
     *      string calling the toString of each member variable in the Club object.
     * </p>
     * @return
     *     - String dump of all member variables.
     */
    @Override
    public String toString() {
        return "Club Title: "   + mClubTitle  +
                "\nCollege: "       +
                //"\nAdmin: "     + mAdmin      +
                "\nID: "        + mId;
    }

    public String getId() {
        return mId;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    public void setCity(String city) {
        mCity = city;
    }

    public void setAdminIds(LinkedList<String> adminIds) {
        mAdminIds = adminIds;
    }

    public void setState(String state) {
        mState = state;
    }

    public void setMemberIds(LinkedList<String> memberIds) {
        mMemberIds = memberIds;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public void setCollegeId(String collegeId) {
        mCollegeId = collegeId;
    }

    public String getCollegeId() {
        return mCollegeId;
    }

    public String getCity() {
        return mCity;
    }

    public String getState() {
        return mState;
    }

    public LinkedList<String> getMemberIds() {
        return mMemberIds;
    }

    public LinkedList<String> getAdminIds() {
        return mAdminIds;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public String getDescription() {
        return mDescription;
    }
}
