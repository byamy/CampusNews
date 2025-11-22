package com.campus.events;

import com.campus.model.User;

public class Athletic extends Events {

    public Athletic(String title, String description, String date, String time, String location, User creator) {
        super(title, description, date, time, location, creator);
    }

    @Override
    public String getEventType() {
        return "Athletic";
    }
}
