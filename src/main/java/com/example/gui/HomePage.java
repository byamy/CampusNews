/**
 * @author Group 2
 * Date    11/22/25
 * Purpose launcher for the Gui, starts scene at "Home.fmxl"
 */

package com.example.gui;

import javafx.application.Application;
import javafx.stage.Stage;

public class HomePage extends Application {
    /**
     *
     *
     * @param stage the primary stage for this application, onto which
     * the application scene can be set.
     * Applications may create other stages, if needed, but they will not be
     * primary stages.
     */
    @Override
    public void start(Stage stage) {
        // Set the primary stage in SceneSwitch
        SceneSwitch.setStage(stage);

        // Switch to homepage.fxml
        SceneSwitch.goTo("homepage.fxml");

        stage.setTitle("Campus News Homepage");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
