package com.example.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;


public class HomePageController {

    @FXML
    private Button viewEventButton;

    @FXML
    private Button createEventButton;

    @FXML
    private Button deleteEventButton;

    @FXML
    private void viewEventButtonPressed(ActionEvent event) {
        SceneSwitch.goTo("eventPage.fxml");
    }

    @FXML
    private void createEventButtonPressed(ActionEvent event) {
        SceneSwitch.goTo("createEventPage.fxml");
    }

    @FXML
    private void deleteEventButtonPressed(ActionEvent event) {
        SceneSwitch.goTo("deleteEventPage.fxml");
    }
}