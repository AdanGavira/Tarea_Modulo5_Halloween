package org.example.tarea_modulo5_halloween;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EntradaTunel extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EntradaTunel.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("Halloween.css").toExternalForm());
        stage.setTitle("Entrada al Túnel del Terror");
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {
        launch();
    }

    public void onEntrar(ActionEvent actionEvent) {
            System.out.println("¡Has entrado al túnel del terror!");
        }
}
