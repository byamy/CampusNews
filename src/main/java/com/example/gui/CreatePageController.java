package com.example.gui;

import com.campus.events.Academic;
import com.campus.events.Athletic;
import com.campus.events.Club;
import com.campus.events.Events;
import com.campus.model.EventsManager;
import com.campus.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Group 2
 * Date    11/22/25
 * Purpose to create an Event in the Listview datacells in the Event fxml to display location, meeting times,
 * and the description for the events.
 *
 */
public class CreatePageController {

    @FXML private ComboBox<String> eventTimePicker;
    @FXML private TextField creator850;
    @FXML private TextField creatorEmail;
    @FXML private DatePicker eventDatePicker;
    @FXML private TextField eventTime;
    @FXML private TextField eventLocation;
    @FXML private TextField eventDescription;
    @FXML private ComboBox<String> eventTypeSelector;
    @FXML private ListView<String> eventListView;
    @FXML private Button createEventButton;
    @FXML private Button returnHomeButton;


    @FXML
    public void initialize() {
        // Populate event type dropdown
        eventTypeSelector.setItems(FXCollections.observableArrayList("Athletic", "Academic", "Club"));
        eventTypeSelector.getSelectionModel().selectFirst();
        eventDatePicker.setDayCellFactory(picker -> new DateCell() {//allows to have multiple cell
                                                                              //filtering
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(empty || date.isBefore(LocalDate.now()));
            }
        });
        // Populates Time Picker with 15 minute intervals from 6 to 23:45
        ObservableList<String> times = FXCollections.observableArrayList();
        LocalTime t = LocalTime.of(6, 0); // Start earliest time
        while (!t.equals(LocalTime.of(23, 45))) {//add intervals of 15minutes starting at 6:00am
            times.add(t.toString());
            t = t.plusMinutes(15);
        }
        times.add("23:45"); // last entry
        eventTimePicker.setItems(times);

    }

    /**
     * Purpose - Takes all selected and inputted values and creates a new event and user instance
     * @param event
     */
    @FXML
    private void createEventButtonPressed(ActionEvent event) {
        // 850 and Email
        String creatorId   = creator850.getText().trim();
        String creatorMail = creatorEmail.getText().trim();

        // Date
        LocalDate dateValue = eventDatePicker.getValue();
        String date = (dateValue == null) ? "" : dateValue.toString();

        // Time
        String time = eventTimePicker.getSelectionModel().getSelectedItem();
        if (time == null) {
            showAlert("Error", "Please select a time.");
            return;
        }

        // Text boxes and type
        String location    = eventLocation.getText().trim();
        String description = eventDescription.getText().trim();
        String type        = eventTypeSelector.getSelectionModel().getSelectedItem();

        // Validate 850#
        if (!creatorId.matches("850\\d{6}")) {
            showAlert("Invalid 850 Number",
                    "Your 850 number must start with 850 and be exactly 9 digits (e.g., 850123456).");
            return;
        }

        // Validate UNCW Email
        if (!creatorMail.endsWith("@uncw.edu")) {
            showAlert("Invalid Email",
                    "Your email must end with @uncw.edu");
            return;
        }

        //Prompts user if title and description are not split
        if (description.matches("\\s-\\s")){
            showAlert("Invalid Input","Must match the format: Title-Description");
        }

        //Prompts user if there is no hyphen
        if (!description.contains("-")) {
            showAlert("Invalid Input", "Must match the format: Title-Description");
            return;
        }

        //Prompts user if Field is left empty
        if (description.isEmpty()) {
            showAlert("Invalid Input", "Description cannot be empty. Please enter a Title-Description.");
            return;
        }

        // Splits description into title and description
        String[] description2 = description.split("-",2);
        String title = description2[0];
        description = description2[1];

        User creator = new User(creatorId, creatorMail);
        //Makes an object based on the Event type
        Events newEvent;
        switch (type) {
            case "Athletic":
                newEvent = new Athletic(title, description, date, time, location, creator);
                break;
            case "Academic":
                newEvent = new Academic(title, description, date, time, location, creator);
                break;
            case "Club":
                newEvent = new Club(title, description, date, time, location, creator);
                break;
            default:
                showAlert("Error", "Unknown event type selected.");
                return;
        }
        //adds it to a list to transfer to EventPage
        EventsManager.addEvent(newEvent);
        refreshEventListView(newEvent);


        // Prompt that event was made
        showAlert("Success", "Event created successfully!");

        // Clear variables
        creator850.clear();
        creatorEmail.clear();
        eventDatePicker.setValue(null);
        eventTimePicker.setValue(null);
        eventLocation.clear();
        eventDescription.clear();
    }

    private void refreshEventListView(Events eventJustCreated) {
        eventListView.getItems().clear();

        if (eventJustCreated != null) {
            eventListView.getItems().add(
                    eventJustCreated.getTitle() + " — " +
                            eventJustCreated.getDate() + " at " +
                            eventJustCreated.getTime()
            );
        }
    }

    //Takes user to homepage
    @FXML
    private void returnHomeButtonPressed(ActionEvent event) {
        SceneSwitch.goTo("homepage.fxml");
    }


    // Allows user to press enter to move to next field when done
    @FXML private void creator850Entered(ActionEvent event)
    { creatorEmail.requestFocus(); }
    @FXML private void creatorEmailEntered(ActionEvent event)
    { eventDatePicker.requestFocus(); }
    @FXML
    private void eventDateEntered(ActionEvent event) {
        eventTimePicker.requestFocus();
    }
    @FXML private void eventTimeEntered(ActionEvent event)
    { eventLocation.requestFocus(); }
    @FXML private void eventLocationEntered(ActionEvent event)
    { eventDescription.requestFocus(); }
    @FXML private void eventDescriptionEntered(ActionEvent event)
    { createEventButtonPressed(null); }

    //Shows an alert for event created
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
