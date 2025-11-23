package com.campus.events;

import com.campus.model.User;

/**
 *
 *
 * @author Group 2
 * Date    11/22/25
 * Purpose A created Subclass of Events using the super method of getEventType.
 */
public class Club extends Events {

    //Constructor
    public Club(String title, String description, String date, String time, String location, User creator) {
        super(title, description, date, time, location, creator);
    }

    @Override
    public String getEventType() {
        return "Club";
    }
}
