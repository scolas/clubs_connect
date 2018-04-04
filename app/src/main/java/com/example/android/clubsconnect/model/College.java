package com.example.android.clubsconnect.model;

import android.support.v4.util.ArrayMap;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class College {
    private static final String KEY_NAME= "name";

    private String mName;
    private String mId;

    public College(){}

    public static College fromMap(Object oMap) {
        Objects.requireNonNull(oMap);
        if (!(oMap instanceof Map)) {
            throw new IllegalArgumentException("Message.fromMap requires a map object");
        }
        final College college = new College();
        Map<String, Object> map = (Map<String, Object>) oMap;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object oValue = entry.getValue();
            switch (key) {
                case KEY_NAME:
                    college.setName((String) oValue);
                    break;
            }
        }
        return college;

    }

    public Map<String, Object> toMap() {
        final ArrayMap<String, Object> map = new ArrayMap<>();
        map.put(KEY_NAME, getName());
        return map;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
}
