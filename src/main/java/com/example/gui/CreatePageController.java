package com.example.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import jdk.jfr.StackTrace;

import java.io.IOError;
import java.io.IOException;
import java.util.Arrays;

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
    private void returnHomeButtonPressed (ActionEvent event) {SceneSwitch.goTo("homepage.fxml");
    }

    /**
     *          // add code
     *          // needs to create a new event with info provided
     *
     *
     */

    /**
     *
     * these are the local variables for the list elements for events
     *
     */
    private ObservableList<String>  eventList = FXCollections.observableArrayList();



    @FXML
    private void createEventButtonPressed (ActionEvent event) {
        String number = creator850.getText().trim();
        String email = creatorEmail.getText().trim().toLowerCase();
        String date = eventDate.getText();
        String time = eventTime.getText().trim();
        String location = eventLocation.getText().toLowerCase();
        String description = eventDescription.getText();
        String numberValidate = "850";


        if (!number.matches("\\d+")){
            System.out.println("Not a number");
            return;
        }
        if (!number.startsWith(numberValidate)){

            System.out.printf("Number must be a One card number starting with %s%n ",numberValidate);
            return;
        }


        int oneCard = Integer.parseInt(number);//now have the one card for list


        if (!email.endsWith("@uncw.edu")){
            System.out.println("This is not a UNCW email.");
            return;
        }
        if(!date.matches("(0[1-9]|1[0-9]|2[0-9]|3[0-1])/(0[1-9]|1[1-2])/(202[5-9])")){
            System.out.println("Date must be in DD/MM/YYYY format");
            return;
        }
        if(!time.matches("(0[0-9]|1[0-9]|2[0-4]):(0[0-9]|1[0-9]|2[0-9]|3[0-9]|4[0-9]|5[0-9])")){
            System.out.println("Must be in 00:00 format");
            return;
        }
        String[] uncwLocations= new String[5];
        uncwLocations[0] = "Cogdon";
        uncwLocations[1]  ="fisher union";
        uncwLocations[2] = "cameron";
        uncwLocations[3]="wagner";
        uncwLocations[4]="randall";
        if(!Arrays.asList(uncwLocations).contains(location)){
            System.out.println("Not one on the list");
            return;
        }
        if(description.isBlank()){
            System.out.println("Must type something");
            return;
        }
        if(number.isEmpty() || email.isEmpty()|| date.isEmpty()||time.isEmpty()|| location.isEmpty()
                ||description.isEmpty()){
            System.out.println("All fields must be filled with the correct information");
            return;
        }
        String addeventdetails = date+" |"+time+" |"+location+" |"+description;
        eventList.add(addeventdetails);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("eventPage.fxml"));
        Parent root;
        try{
            root = loader.load();
            EventPageController EventPageController = loader.getController();
            EventPageController.setListView(eventList);
            SceneSwitch.goTo(root);
        }
        catch (IOException e){
            e.printStackTrace();
        }



    }

    // ALL OF THESE NEED CODE ADDED TO THEM IN ORDER TO CREATE AND DISPLAY A NEW EVENT //
    @FXML
    private void creator850Entered (ActionEvent event) {
        try {
            int input = Integer.parseInt(creator850.getText());

        }
        catch (NumberFormatException e){
            System.out.println("not a valid number");
        }
    }


    @FXML
    private void creatorEmailEntered (ActionEvent event) {
        try{
            String email = creatorEmail.getText();
        }
        catch (Exception e){
            System.out.println("How did you mess up a String?");
        }
    }

    @FXML
    private void eventDateEntered (ActionEvent event) {
        try{
            String date = eventDate.getText();
        }
        catch (Exception e){
            System.out.println("wrong input");
        }
    }

    @FXML
    private void eventTimeEntered (ActionEvent event) {
        try{
            String time = eventTime.getText();
        }
        catch (Exception e){
            System.out.println("wrong input");
        }
    }


    @FXML
    private void eventLocationEntered (ActionEvent event) {
        try{
            String date = eventLocation.getText();
        }
        catch (Exception e){
            System.out.println("wrong input");
        }
    }


    @FXML
    private void eventDescriptionEntered (ActionEvent event) {
        try{
            String date = eventDescription.getText();
        }
        catch (Exception e){
            System.out.println("wrong input");
        }
    }
}
