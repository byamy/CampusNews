package com.campus.events;

import com.campus.model.User;

public class Club extends Events {

    public Club(String title, String description, String date, String time, String location, User creator) {
        super(title, description, date, time, location, creator);
    }

    @Override
    public String getEventType() {
        return "Club";
    }
}
