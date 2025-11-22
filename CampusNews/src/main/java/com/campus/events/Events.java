package com.campus.events;

import com.campus.model.User;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public abstract class Events implements RSVPable {

    private String title;
    private String description;
    private String date;
    private String time;
    private String location;

    private User creator;
    private List<User> rsvpedUsers;

    public Events(String title, String description, String date, String time, String location, User creator) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.time = time;
        this.location = location;
        this.creator = creator;
        this.rsvpedUsers = new ArrayList<>();
    }

    // ABSTRACT: MUST BE IMPLEMENTED BY SUBCLASSES
    public abstract String getEventType();

    // Getters/setters
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getDate() { return date; }
    public String getTime() { return time; }
    public String getLocation() { return location; }

    public User getCreator() { return creator; }
    public void setCreator(User creator) { this.creator = creator; }

    // RSVPable implementation
    @Override
    public void addRSVP(User user) {
        if (!rsvpedUsers.contains(user)) {
            rsvpedUsers.add(user);
        }
    }

    @Override
    public int getRsvpCount() {
        return rsvpedUsers.size();
    }

    public List<User> getRsvpedUsers() { return rsvpedUsers; }

    // Helpers
    public LocalDate getDateAsLocalDate() {
        return LocalDate.parse(this.date, DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public String getType() {
        return getEventType();
    }
}
