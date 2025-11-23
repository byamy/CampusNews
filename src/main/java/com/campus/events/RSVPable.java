package com.campus.events;

import com.campus.model.User;

/**
 * @author Group 2
 * Date 11/22/25
 * Purpose Interface for EventPage Controller from Events class, allowing abstraction by implementations.
 *
 */
public interface RSVPable {
    void addRSVP(User user);
    int getRsvpCount();
}

