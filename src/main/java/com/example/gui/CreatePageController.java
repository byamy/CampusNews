package com.example.gui;

import com.campus.events.Events;
import com.campus.events.Athletic;
import com.campus.events.Academic;
import com.campus.events.Club;
import com.campus.model.EventsManager;

import com.campus.model.User;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.LocalDate;

import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyles.title;

public class CreatePageController {

    @FXML private TextField user850;
    @FXML private TextField userEmail;
    @FXML private TextField eventTitle
    @FXML private DatePicker eventDatePicker;
    @FXML private TextField eventTime;
    @FXML private TextField eventLocation;
    @FXML private TextField eventDescription;
    @FXML private ComboBox<String> eventTypeSelector;
    @FXML private ListView<String> eventListView;
    @FXML private Button createEventButton;
    @FXML private Button returnHomeButton;

    private EventPageController eventPageController; // reference to EventPageController

    @FXML
    public void initialize() {
        eventTypeSelector.setItems(FXCollections.observableArrayList("Athletic", "Academic", "Club"));
        eventTypeSelector.getSelectionModel().selectFirst();
        refreshEventListView();
    }

    public void setEventPageController(EventPageController controller) {
        this.eventPageController = controller;
    }

    @FXML
    private void createEventButtonPressed(ActionEvent event) {
        String creatorName = user850.getText();
        String creatorMail = userEmail.getText();
        LocalDate dateValue = eventDatePicker.getValue();
        String date = dateValue == null ? "" : dateValue.toString();
        String time = eventTime.getText();
        String location = eventLocation.getText();
        String description = eventDescription.getText();
        String type = eventTypeSelector.getSelectionModel().getSelectedItem();

        if (creatorName.isEmpty() || creatorMail.isEmpty() || date.isEmpty() || time.isEmpty() ||
                location.isEmpty() || description.isEmpty()) {
            showAlert("Error", "All fields must be filled out.");
            return;
        }

        Events newEvent;
        User creator = new User(user850.getText(), userEmail.getText()); // Assuming you have TextFields for 850# and email

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
                showAlert("Error", "Unknown event type selected");
                return;
        }

        EventsManager.addEvent(newEvent);


        // Update EventPageController if it exists
        if (eventPageController != null) {
            eventPageController.refreshEventLists();
        }

        refreshEventListView();
        showAlert("Success", "Event created successfully!");

        creator850.clear();
        creatorEmail.clear();
        eventDatePicker.setValue(null);
        eventTime.clear();
        eventLocation.clear();
        eventDescription.clear();
    }

    private void refreshEventListView() {
        eventListView.getItems().clear();
        for (Events e : EventsManager.getAllEvents()) {
            eventListView.getItems().add(e.getType() + ": " + e.getDescription() + " on " + e.getDate());
        }
    }

    @FXML
    private void returnHomeButtonPressed(ActionEvent event) {
        SceneSwitch.goTo("homepage.fxml");
    }

    @FXML private void creator850Entered(ActionEvent event) { creatorEmail.requestFocus(); }
    @FXML private void creatorEmailEntered(ActionEvent event) { eventDatePicker.requestFocus(); }
    @FXML private void eventDateEntered(ActionEvent event) { eventTime.requestFocus(); }
    @FXML private void eventTimeEntered(ActionEvent event) { eventLocation.requestFocus(); }
    @FXML private void eventLocationEntered(ActionEvent event) { eventDescription.requestFocus(); }
    @FXML private void eventDescriptionEntered(ActionEvent event) { createEventButtonPressed(null); }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
