package com.campus.events;

import com.campus.model.User;

/**
 *
 * @author Group 2
 * Date    11/22/25
 * purpose to create an inherited subclass of Events,using Ovvride method of a super method
 */
public class Athletic extends Events {

    //Constructor
    public Athletic(String title, String description, String date, String time, String location, User creator) {
        super(title, description, date, time, location, creator);
    }

    @Override
    public String getEventType() {
        return "Athletic";
    }
}
