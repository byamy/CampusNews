package com.campus.events;

import com.campus.model.User;

/**
 *
 * @author Group 2
 * Date    11/22/25
 * Purpose A subclass that inherited from Events and the Super method getEventType override method
 */
public class Academic extends Events {

    public Academic(String title, String description, String date, String time, String location, User creator) {
        super(title, description, date, time, location, creator);
    }

    @Override
    public String getEventType() {
        return "Academic";
    }
}
