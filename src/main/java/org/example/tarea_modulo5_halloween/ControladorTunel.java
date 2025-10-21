package org.example.tarea_modulo5_halloween;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.PauseTransition;

import java.io.IOException;

public class ControladorTunel {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtApellidos;

    @FXML
    private ComboBox<String> Cursos;

    @FXML
    private Button btnEntrar;

    @FXML
    private Label tituloLabel;

    @FXML
    public void initialize() {
        Cursos.getItems().addAll("DAM1", "DAM2", "DAW1", "DAW2", "SMR1", "SMR2");
        Cursos.setPromptText("Selecciona tu curso...");
    }

    @FXML
    private void onEntrar(ActionEvent event) {
        String nombre = txtNombre.getText().trim();
        String apellidos = txtApellidos.getText().trim();
        String curso = Cursos.getValue();

        if (nombre.isEmpty() || apellidos.isEmpty() || curso == null) {
            tituloLabel.setText("¡No puedes entrar sin revelar tu identidad!");
            tituloLabel.setTextFill(javafx.scene.paint.Color.RED);

            PauseTransition pausa = new PauseTransition(Duration.seconds(4));
            pausa.setOnFinished(e -> {
                tituloLabel.setText("Entrada al Túnel del Terror");
                tituloLabel.setTextFill(javafx.scene.paint.Color.ORANGE);
            });
            pausa.play();
        } else {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ruleta.fxml"));
                Parent root = loader.load();

                ControladorRuleta controladorRuleta = loader.getController();
                controladorRuleta.setDatosParticipante(nombre, apellidos, curso);

                Scene scene = new Scene(root);
                scene.getStylesheets().add(getClass().getResource("RuletaHalloween.css").toExternalForm());

                Stage stage = (Stage) btnEntrar.getScene().getWindow();
                stage.setScene(scene);
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}







