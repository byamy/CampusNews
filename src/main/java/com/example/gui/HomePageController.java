package com.example.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;


/**
 *
 * @author Group 2
 * Date    11/22/25
 * Purpose the Controller gui for the homepage.fxml
 */
public class HomePageController {
    /**
     *
     *
     * methods/ action Events
     * createEventButtonPressed- switched the scene to the Create Event page
     * viewEventButtonPressed - checks the available events that they are by switching to the event page
     * returnHomeButtonPressed- not used
     * deleteEventButtonPressed- Switch window to the Delete Screen
     */


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
