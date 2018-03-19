package com.example.android.clubsconnect.model;

import java.util.ArrayList;

/**
 * Created by ProfessorTaha on 3/3/2018.
 */

class Person {

    //alternative to populating id w/ unique value of Object id in db (returned from Presenter)
    private static long personCount;

    private String mId;

    //List of IDs for clubs -- which means we must make club.mId unique
    private ArrayList<Integer> clubsJoined;

    private String mUserName;


    Person(){
        //make call to static dbHelper.createPerson? (IDK nomenclature yet) returning String Id from firebase
        //mId = FirebaseHelper.addPerson();
        //OR possibly put static long attribute/property personCount;
        mId = String.valueOf(personCount++);

    }

    //Test constructor taking name
    public Person(String name){
        this();
        this.mUserName = name;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }

}
