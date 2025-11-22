package com.example.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

public class HomePageController {

    @FXML
    private void createEventButtonPressed(ActionEvent event) {
        SceneSwitch.goTo("createEventPage.fxml");
    }

    @FXML
    private void viewEventButtonPressed(ActionEvent event) {
        SceneSwitch.goTo("eventPage.fxml");
    }


    @FXML
    private void returnHomeButtonPressed(ActionEvent event) {
        // Handle returning to home if needed
    }

    @FXML
    private void deleteEventButtonPressed(ActionEvent event) {
        SceneSwitch.goTo("deleteEventPage.fxml");
    }

}
