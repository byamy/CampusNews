package com.example.gui;

import com.campus.model.EventsManager;
import com.campus.events.Events;
import com.campus.model.User;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;

/**
 *
 * @author Group 2
 * Date    11/22/25
 * Purpose to Delete an event made previously by the user and won't allow anyone beside the original creator
 *         of the event to delete it.
 */
public class DeletePageController {

    @FXML
    private Button returnHomeButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TextField deleteEmail;

    @FXML
    private TextField delete850;

    @FXML
    private ListView<Events> deleteListView;

    @FXML
    private Label errorLabel;

    @FXML
    private void returnHomeButtonPressed(ActionEvent event) {
        SceneSwitch.goTo("homepage.fxml");
    }

    /**
     *
     * Purpose to delete an event by verifying if the Event_List has the creators 850 and email
     * to verify its creator.
     *
     */
    @FXML
    void deleteButtonAction(ActionEvent event) {
        Events selectedEvent = deleteListView.getSelectionModel().getSelectedItem();
        if (selectedEvent != null) {
            String entered850   = delete850.getText().trim();
            String enteredEmail = deleteEmail.getText().trim();

            if (entered850.isEmpty() || enteredEmail.isEmpty()) {
                errorLabel.setText("Please enter both 850 number and email.");
                return;
            }

            boolean removed = EventsManager.deleteEvent(selectedEvent, entered850, enteredEmail);
            if (removed) {
                deleteListView.getItems().remove(selectedEvent);
                errorLabel.setText("Event deleted successfully!");
            } else {
                errorLabel.setText("850# or email does not match the event creator.");
            }
        } else {
            errorLabel.setText("No event selected.");
        }
    }

    /**
     *
     * deleteEmailEntered and delete850Entered is unnecessary  due to the button Action so we might delete
     * @param event
     */
    @FXML
    private void deleteEmailEntered(ActionEvent event) {
        // optional: handle Enter pressed in email field
    }

    @FXML
    private void delete850Entered(ActionEvent event) {
        // optional: handle Enter pressed in 850# field
    }

    /**
     *
     * Purpose Display the list of current events active and allow user to select an event to delete.
     */
    @FXML
    public void initialize() {
        // Populate ListView with all events
        deleteListView.getItems().addAll(EventsManager.getAllEvents());
        // Optional: set custom cell factory for nicer display
        deleteListView.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(Events e, boolean empty) {
                super.updateItem(e, empty);
                if (empty || e == null) {
                    setText(null);
                } else {
                    setText(e.getType() + ": " + e.getTitle() + " on " + e.getDate());
                }
            }
        });
    }
}
