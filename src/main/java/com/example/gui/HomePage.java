/**
 * Launcher
 *
 */

package com.example.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HomePage extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        SceneSwitch.setStage(stage);

        Parent root = FXMLLoader.load(getClass().getResource("homepage.fxml"));

        Scene scene = new Scene(root);
        stage.setTitle("homepage");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}