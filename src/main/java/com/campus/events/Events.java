package com.campus.events;

import com.campus.model.User;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public abstract class Events {
    private String title;
    private String description;
    private String date;
    private String time;
    private String location;
    private User creator; // new creator field

    private List<User> rsvpedUsers = new ArrayList<>();

    public Events(String title, String description, String date, String time, String location, User creator) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.time = time;
        this.location = location;
        this.creator = creator;
    }

    // Getters and Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public User getCreator() { return creator; }
    public void setCreator(User creator) { this.creator = creator; }

    public void addRSVP(User user) {
        if (!rsvpedUsers.contains(user)) {
            rsvpedUsers.add(user);
        }
    }

    public List<User> getRsvpedUsers() { return rsvpedUsers; }

    public int getRsvpCount() {
        return rsvpedUsers.size();
    }


    public LocalDate getDateAsLocalDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        return LocalDate.parse(this.date, formatter);
    }

    public String getType() {
        if (this instanceof Athletic) return "Athletic";
        if (this instanceof Academic) return "Academic";
        if (this instanceof Club) return "Club";
        return "Unknown";
    }

    public abstract String getEventType();
}
