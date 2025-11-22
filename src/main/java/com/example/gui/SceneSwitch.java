package com.example.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class SceneSwitch {
    private static Stage mainStage;

    public static void setStage(Stage stage) {
        mainStage = stage;
    }

    public static void goTo(String fxml) {
        try {
            Parent root = FXMLLoader.load(SceneSwitch.class.getResource(fxml));
            mainStage.setScene(new Scene(root));
            mainStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * overloaded method for parent root for list transfer
     * @param root
     */
    public static void goTo(Parent root){
        mainStage.setScene(new Scene(root));
        mainStage.show();

    }
}
