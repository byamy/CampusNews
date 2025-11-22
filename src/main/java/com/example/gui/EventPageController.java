package com.example.gui;

import com.campus.events.Events;
import com.campus.events.Athletic;
import com.campus.events.Academic;
import com.campus.events.Club;
import com.campus.model.EventsManager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.Comparator;

public class EventPageController {

    @FXML private ListView<String> athleticEvent;
    @FXML private ListView<String> clubEvent;
    @FXML private ListView<String> academicEvent;
    @FXML private CheckBox userStudentCheckBox;
    @FXML private CheckBox userFacultyCheckBox;
    @FXML private CheckBox userVisitorCheckBox;
    @FXML private TextField userEmail;
    @FXML private TextField numPeople;
    @FXML private Button rsvpButton;
    @FXML private Button returnHomeButton;

    // Master event list
    private final ObservableList<Events> allEvents = FXCollections.observableArrayList();

    // Type-specific lists
    private final ObservableList<Events> athleticEvents = FXCollections.observableArrayList();
    private final ObservableList<Events> clubEvents = FXCollections.observableArrayList();
    private final ObservableList<Events> academicEvents = FXCollections.observableArrayList();

    // ---------------- Initialization ----------------
    @FXML
    public void initialize() {
        // Pull all events from EventsManager
        allEvents.clear();
        allEvents.addAll(EventsManager.getAllEvents());

        // Refresh the lists so each ListView shows events by type and sorted by date
        refreshEventLists();
    }

    // ---------------- Event Handlers ----------------
    @FXML private void userStudentCheckBoxAction(ActionEvent event) {
        System.out.println("Student checkbox toggled: " + userStudentCheckBox.isSelected());
    }

    @FXML private void userFacultyCheckBoxAction(ActionEvent event) {
        System.out.println("Faculty checkbox toggled: " + userFacultyCheckBox.isSelected());
    }

    @FXML private void userVisitorCheckBoxAction(ActionEvent event) {
        System.out.println("Visitor checkbox toggled: " + userVisitorCheckBox.isSelected());
    }

    @FXML private void userEmailEntered(ActionEvent event) {
        System.out.println("User email entered: " + userEmail.getText());
    }

    @FXML private void numPeopleEntered(ActionEvent event) {
        System.out.println("# of people entered: " + numPeople.getText());
    }

    @FXML private void rsvpButtonPressed(ActionEvent event) {
        showAlert("RSVP", "RSVP functionality not implemented yet.");
    }

    @FXML private void returnHomeButtonPressed(ActionEvent event) {
        SceneSwitch.goTo("homepage.fxml");
    }

    // ---------------- Event Management ----------------
    public void addEvent(Events event) {
        allEvents.add(event);

        if (event instanceof Athletic) {
            athleticEvents.add(event);
        } else if (event instanceof Club) {
            clubEvents.add(event);
        } else if (event instanceof Academic) {
            academicEvents.add(event);
        }

        // Refresh all lists and sort them
        refreshEventLists();
    }

    @FXML
    public void refreshEventLists() {
        // Clear type-specific lists
        athleticEvents.clear();
        clubEvents.clear();
        academicEvents.clear();

        // Add events to the respective lists
        for (Events e : allEvents) {
            if (e instanceof Athletic) {
                athleticEvents.add(e);
            } else if (e instanceof Club) {
                clubEvents.add(e);
            } else if (e instanceof Academic) {
                academicEvents.add(e);
            }
        }

        // Sort each list by date
        FXCollections.sort(athleticEvents, Comparator.comparing(Events::getDate));
        FXCollections.sort(clubEvents, Comparator.comparing(Events::getDate));
        FXCollections.sort(academicEvents, Comparator.comparing(Events::getDate));

        // Update the ListViews
        updateListView(athleticEvent, athleticEvents);
        updateListView(clubEvent, clubEvents);
        updateListView(academicEvent, academicEvents);
    }

    private void updateListView(ListView<String> listView, ObservableList<Events> events) {
        listView.getItems().clear();
        for (Events e : events) {
            listView.getItems().add(e.getType() + ": " + e.getDescription() + " on " + e.getDate());
        }
    }

    // ---------------- Utility ----------------
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


}
