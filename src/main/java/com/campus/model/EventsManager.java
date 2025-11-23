package com.campus.model;

import com.campus.events.*;
import com.campus.model.User;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Group 2
 * Date    11/22/25
 * Purpose Have a centralized area for List of Academic, Athletic, and Club ArrayList for EventPageController,and
 *         usage in the CreatePageController.
 */
public class EventsManager {

    private static final ObservableList<Events> allEvents = FXCollections.observableArrayList();

    public static ObservableList<Events> getAllEvents() {
        return allEvents;
    }

    public static void addEvent(Events event) {
        allEvents.add(event);
        allEvents.sort(Comparator.comparing(Events::getDateAsLocalDate));
    }

    public static boolean deleteEvent(Events event, String username, String email) {
        User creator = event.getCreator();
        if (creator.getUsername().equals(username) && creator.getEmail().equals(email)) {
            return allEvents.remove(event);
        }
        return false;
    }

    public static List<Events> getAthleticEvents() {
        return allEvents.stream()
                .filter(e -> e instanceof Athletic)
                .sorted(Comparator.comparing(Events::getDateAsLocalDate))
                .collect(Collectors.toList());
    }

    public static List<Events> getAcademicEvents() {
        return allEvents.stream()
                .filter(e -> e instanceof Academic)
                .sorted(Comparator.comparing(Events::getDateAsLocalDate))
                .collect(Collectors.toList());
    }

    public static List<Events> getClubEvents() {
        return allEvents.stream()
                .filter(e -> e instanceof Club)
                .sorted(Comparator.comparing(Events::getDateAsLocalDate))
                .collect(Collectors.toList());
    }
}
