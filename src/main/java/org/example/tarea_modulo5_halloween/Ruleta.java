package org.example.tarea_modulo5_halloween;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class Ruleta extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Cargar el archivo FXML desde el paquete correcto
        FXMLLoader loader = new FXMLLoader(Ruleta.class.getResource("Ruleta.fxml"));
        Parent root = loader.load();

        // Crear la escena y aplicar el CSS
        Scene scene = new Scene(root);
        scene.getStylesheets().add(Ruleta.class.getResource("RuletaHalloween.css").toExternalForm());

        // Configurar la ventana principal
        primaryStage.setTitle("Entrada al Túnel del Terror");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}



