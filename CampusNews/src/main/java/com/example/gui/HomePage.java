package com.example.gui;

import javafx.application.Application;
import javafx.stage.Stage;

public class HomePage extends Application {

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
