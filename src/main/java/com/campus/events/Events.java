package com.campus.events;

import com.campus.model.User;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Group 2
 * Date 11/22/25
 * Purpose
 */
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


    public abstract String getEventType();

    // Getters/setters

    /**
     *
     *
     * @return String title
     */
    public String getTitle() { return title; }

    /**
     *
     *
     * @return String description
     */
    public String getDescription() { return description; }

    /**
     *
     *
     * @return String date
     */
    public String getDate() { return date; }

    /**
     *
     *
     * @return String time
     */
    public String getTime() { return time; }

    /**
     *
     * @return String location
     */
    public String getLocation() { return location; }

    /**
     *
     *
     * @return user Datatype  creator from User class
     */
    public User getCreator() { return creator; }

    /**
     *
     * set creator to this instance.
     * @param creator
     */
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


    public LocalDate getDateAsLocalDate() {
        return LocalDate.parse(this.date, DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public String getType() {
        return getEventType();
    }
}
