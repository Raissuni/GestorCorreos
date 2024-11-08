package org.example.gestor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ExamenApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ExamenApplication.class.getResource("examen-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 620, 500);
        stage.setTitle("Gestor de Emails");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}