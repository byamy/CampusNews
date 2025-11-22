package com.campus.events;

import com.campus.model.User;

public interface RSVPable {
    void addRSVP(User user);
    int getRsvpCount();
}

