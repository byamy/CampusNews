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

import java.util.Comparator;

/**
 *
 * @author Group 2
 * Date    11/22/25
 * Purpose Initiliazing EventList and showing Events from createPage controller.
 * param   takes in information as a ArrayList from CreatePageController and
 *         utilizes the infomation in a list format.
 */
public class EventPageController {


    @FXML private ListView<String> athleticEvent;
    @FXML private ListView<String> clubEvent;
    @FXML private ListView<String> academicEvent;
    @FXML private CheckBox userStudentCheckBox;
    @FXML private CheckBox userFacultyCheckBox;
    @FXML private CheckBox userVisitorCheckBox;
    @FXML private TextField userEmail;
    @FXML private TextField numPeople;
    @FXML private Button rsvpButton;
    @FXML private Button returnHomeButton;

    // Main Event List
    private final ObservableList<Events> allEvents       = FXCollections.observableArrayList();
    // Other Event Lists
    private final ObservableList<Events> athleticEvents  = FXCollections.observableArrayList();
    private final ObservableList<Events> clubEvents      = FXCollections.observableArrayList();
    private final ObservableList<Events> academicEvents  = FXCollections.observableArrayList();


    @FXML
    public void initialize() {
        // Load events from EventsManager
        allEvents.clear();
        allEvents.addAll(EventsManager.getAllEvents());


        refreshEventLists();
    }



    @FXML private void userStudentCheckBoxAction(ActionEvent event) {

        if (userStudentCheckBox.isSelected()) {
            userFacultyCheckBox.setSelected(false);
            userVisitorCheckBox.setSelected(false);
        }
    }

    @FXML private void userFacultyCheckBoxAction(ActionEvent event) {
        if (userFacultyCheckBox.isSelected()) {
            userStudentCheckBox.setSelected(false);
            userVisitorCheckBox.setSelected(false);
        }
    }

    @FXML private void userVisitorCheckBoxAction(ActionEvent event) {
        if (userVisitorCheckBox.isSelected()) {
            userStudentCheckBox.setSelected(false);
            userFacultyCheckBox.setSelected(false);
        }
    }

    @FXML private void userEmailEntered(ActionEvent event) {
        numPeople.requestFocus();
    }

    @FXML private void numPeopleEntered(ActionEvent event) {
        rsvpButtonPressed(null);
    }

    /**
     *
     * Purpose to sign up to an available event with a number of people and an email to reference by
     * param   uses the Action Event
     */

    @FXML
    private void rsvpButtonPressed(ActionEvent event) {
        Events selectedEvent = getSelectedEvent();//allow events to be recognized as highlighted
        if (selectedEvent == null) {
            showAlert("Error", "Please select an event to RSVP for.");
            return;
        }

        String email = userEmail.getText().trim();
        if (email.isEmpty()) {
            showAlert("Error", "Please enter your email.");
            return;
        }

        int peopleCount = 1;
        String numText = numPeople.getText().trim();
        if (!numText.isEmpty()) {
            try {
                peopleCount = Integer.parseInt(numText);
                if (peopleCount <= 0) throw new NumberFormatException();
            } catch (NumberFormatException e) {
                showAlert("Error", "'# of People' must be a positive whole number.");
                return;
            }
        }
        //to add the counter for user in that selected event
        String role = "Attendee";
        if (userStudentCheckBox.isSelected()) {
            role = "Student";
        } else if (userFacultyCheckBox.isSelected()) {
            role = "Faculty";
        } else if (userVisitorCheckBox.isSelected()) {
            role = "Visitor";
        }

        // Adds one RSVP count per person
        for (int i = 0; i < peopleCount; i++) {
            selectedEvent.addRSVP(new User(role, email));
        }

        showAlert("RSVP Confirmed",
                "You RSVP'd " + peopleCount + " person(s) to:\n" + selectedEvent.getDescription());

        // Reload display (including RSVP counts)
        refreshEventLists();

        // clear inputs
        numPeople.clear();
    }

    /**
     *
     * Purpose To force user to select an event under the three categories provided
     *
     */
    private Events getSelectedEvent() {

        int index = athleticEvent.getSelectionModel().getSelectedIndex();
        if (index >= 0 && index < athleticEvents.size()) {
            return athleticEvents.get(index);
        }

        index = clubEvent.getSelectionModel().getSelectedIndex();
        if (index >= 0 && index < clubEvents.size()) {
            return clubEvents.get(index);
        }

        index = academicEvent.getSelectionModel().getSelectedIndex();
        if (index >= 0 && index < academicEvents.size()) {
            return academicEvents.get(index);
        }

        return null;
    }

    @FXML
    private void returnHomeButtonPressed(ActionEvent event) {
        SceneSwitch.goTo("homepage.fxml");
    }

    /**
     *
     * Purpose To show a Pop-up of the Event Name and details of the Event including, time, location, counter of
     * people, and a description of the event.
     *
     */
    @FXML
    private void viewDetailsButtonPressed(ActionEvent event) {
        Events selected = getSelectedEvent();

        if (selected == null) {
            showAlert("Error", "Please select an event first.");
            return;
        }


        String details =
                "Title: " + selected.getTitle() + "\n" +
                        "Description: " + selected.getDescription() + "\n" +
                        "Date: " + selected.getDate() + "\n" +
                        "Time: " + selected.getTime() + "\n" +
                        "Location: " + selected.getLocation() + "\n" +
                        "RSVP Count: " + selected.getRsvpCount();
        //develop the alert popup screen when details is pressed
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Event Details");
        alert.setHeaderText(selected.getTitle());
        alert.setContentText(details);


        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.setStyle(
                "-fx-background-color: TEAL;" +
                        "-fx-font-size: 14px;" +
                        "-fx-text-fill: white;"
        );

        alert.showAndWait();
    }




    // Method to allow other controllers to refresh the event lists so create and delete can affect main lists
    @FXML
    public void refreshEventLists() {
        // Ensure we use the latest events from the manager
        allEvents.clear();
        allEvents.addAll(EventsManager.getAllEvents());

        athleticEvents.clear();
        clubEvents.clear();
        academicEvents.clear();

        for (Events e : allEvents) {
            if (e instanceof Athletic) {
                athleticEvents.add(e);
            } else if (e instanceof Club) {
                clubEvents.add(e);
            } else if (e instanceof Academic) {
                academicEvents.add(e);
            }
        }

        // Sort by date using LocalDate
        FXCollections.sort(athleticEvents, Comparator.comparing(Events::getDateAsLocalDate));
        FXCollections.sort(clubEvents, Comparator.comparing(Events::getDateAsLocalDate));
        FXCollections.sort(academicEvents, Comparator.comparing(Events::getDateAsLocalDate));

        updateListView(athleticEvent, athleticEvents);
        updateListView(clubEvent, clubEvents);
        updateListView(academicEvent, academicEvents);
    }

    private void updateListView(ListView<String> listView, ObservableList<Events> events) {
        listView.getItems().clear();
        for (Events e : events) {//for events itll refresh the events list with either new events or events that didn't get shown
            listView.getItems().add(e.getTitle());
        }
    }


    // Alert Method for prompts in other controllers
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
