package com.example.gui;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;


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
    void deleteButtonAction(ActionEvent event) {
    }


    @FXML
    private void returnHomeButtonPressed(javafx.event.ActionEvent event) {
        SceneSwitch.goTo("homepage.fxml");
    }

    @FXML
    private void deleteEmailEntered(javafx.event.ActionEvent event) {
    }

    @FXML
    private void delete850Entered(javafx.event.ActionEvent event) {

    }
}
