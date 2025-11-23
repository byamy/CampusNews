package com.example.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 *
 * @author Group 2
 * Date    11/22/25
 * Purpose to have an easy-to-use method to switch scenes instead of redundent setting scenes and show stage snippets
 *
 */
public class SceneSwitch {

    private static Stage primaryStage;

    // Set the primary stage at application start
    public static void setStage(Stage stage) {
        primaryStage = stage;
    }

    // Switch scenes
    public static void goTo(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(SceneSwitch.class.getResource(fxmlFile));
            Parent root = loader.load();
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load FXML and return the loader to access the controller
    public static FXMLLoader loadFXML(String fxmlFile) throws IOException {
        FXMLLoader loader = new FXMLLoader(SceneSwitch.class.getResource(fxmlFile));
        loader.load();
        return loader;
    }

    // get the primary stage anywhere if needed
    public static Stage getPrimaryStage() {
        return primaryStage;
    }
}
