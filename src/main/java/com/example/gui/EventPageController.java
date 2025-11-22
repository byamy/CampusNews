package com.example.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;



public class EventPageController {

    @FXML
    private TextField numPeople;

    @FXML
    private ListView<String> listView;

    @FXML
    private CheckBox userStudentCheckBox;

    @FXML
    private CheckBox userFacultyCheckBox;

    @FXML
    private CheckBox userVisitorCheckBox;

    @FXML
    private Button returnHomeButton;

    @FXML
    private Button rsvpButton;

    @FXML
    private TextField userEmail;

    @FXML
    private ScrollPane eventDisplay;

    @FXML
    private void userStudentCheckBoxAction(ActionEvent event) {
        if (userStudentCheckBox.isSelected()){
            System.out.println("Checked");
        }
        else{
            System.out.println("Unchecked");
        }



    }

    @FXML
    private void userFacultyCheckBoxAction(ActionEvent event) {

        if (userFacultyCheckBox.isSelected()){
            System.out.println("Checked");
        }
        else{
            System.out.println("Unchecked");
    }}

    @FXML
    private void userVisitorCheckBoxAction(ActionEvent event) {
        if (userVisitorCheckBox.isSelected()){
            System.out.println("Checked");
        }
        else{
            System.out.println("Unchecked");
        }
    }


    /**
     *          // add code
     *          // needs to gather user email and store it somewhere
     * @param event
     */
    @FXML
    private void userEmailEntered(ActionEvent event) {
        userEmail.setEditable(false);
    }

    @FXML
    private void numPeopleEntered(ActionEvent event) {
    }

    @FXML
    private void returnHomeButtonPressed(ActionEvent event) {
        SceneSwitch.goTo("homepage.fxml");
    }

    /**
     *      // add code
     *
     *      // big list needs to display with event time info location etc and needs to be able
     *      // to be itemized so a user can click a specific event when rsvp or simply look
     *
     */

    private ObservableList<String> eventDetails = FXCollections.observableArrayList();
    @FXML
    private void initialize(){

        listView.setItems(eventDetails);

    }
    public void setListView(ObservableList<String>eventDetails){
        this.eventDetails.addAll(eventDetails);
    }




    @FXML
    private void eventDisplayClicked(ActionEvent event) {

    }


    /**
     *          // add code, implement polymorphism here
     *          // use RSVP class to make list of emails and users, stores it
     *          // later, needs to ensure 1 checkbox is selected, email entered, and
     *          // button is clicked in order to make new RSVP object
     *
     *     // basic code maybe?
     *     private void rsvpButtonPressed(ActionEvent event) {
     *     String userType = "";
     *     if (userStudentCheckBox.isSelected()) {
     *         userType = "Student";
     *     } else if (userFacultyCheckBox.isSelected()) {
     *         userType = "Faculty";
     *     } else if (userVisitorCheckBox.isSelected()) {
     *         userType = "Visitor";
     *     }
     *
     *
     */
    @FXML
    private void rsvpButtonPressed(ActionEvent event) {

    }
}


