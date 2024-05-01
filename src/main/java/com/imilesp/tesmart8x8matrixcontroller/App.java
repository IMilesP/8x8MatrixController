package com.imilesp.tesmart8x8matrixcontroller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1063, 677);
        scene.getStylesheets().add(getClass().getResource("App.css").toExternalForm());
        stage.setTitle("TESmart 8x8 HDMI Matrix Controller");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}