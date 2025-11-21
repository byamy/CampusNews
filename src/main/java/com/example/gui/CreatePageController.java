package com.example.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CreatePageController {

    @FXML
    private TextField creator850;

    @FXML
    private TextField creatorEmail;

    @FXML
    private TextField eventDate;

    @FXML
    private TextField eventTime;

    @FXML
    private TextField eventLocation;

    @FXML
    private TextField eventDescription;

    @FXML
    private Button returnHomeButton;

    @FXML
    private Button createEventButton;

    @FXML
    private void returnHomeButtonPressed (ActionEvent event) {
        SceneSwitch.goTo("homepage.fxml");
    }

    /**
     *          // add code
     *          // needs to create a new event with info provided
     *
     *
     */
    @FXML
    private void createEventButtonPressed (ActionEvent event) {
    }

    // ALL OF THESE NEED CODE ADDED TO THEM IN ORDER TO CREATE AND DISPLAY A NEW EVENT //
    @FXML
    private void creator850Entered (ActionEvent event) {
    }

    @FXML
    private void creatorEmailEntered (ActionEvent event) {
    }

    @FXML
    private void eventDateEntered (ActionEvent event) {
    }

    @FXML
    private void eventTimeEntered (ActionEvent event) {
    }


    @FXML
    private void eventLocationEntered (ActionEvent event) {
    }


    @FXML
    private void eventDescriptionEntered (ActionEvent event) {
    }
}
