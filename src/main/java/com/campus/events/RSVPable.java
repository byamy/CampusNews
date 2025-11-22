package com.campus.events;

import com.campus.model.User;

public interface RSVPable {
    void rsvp(User user);
    void cancelRsvp(User user);
    int getRsvpCount();
    User getRsvpUser(); // Track the single RSVP user for demo
}
