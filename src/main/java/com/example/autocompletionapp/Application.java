package com.example.autocompletionapp;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application {
    public Stage run(Stage stage, String title, String fxmlPath) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource(fxmlPath));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();

        return stage;
    }
}
