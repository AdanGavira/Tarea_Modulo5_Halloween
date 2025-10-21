package org.example.tarea_modulo5_halloween;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.List;
import java.util.Random;

public class ControladorRuleta {

    @FXML
    private ImageView fondoImage;

    @FXML
    private ImageView ruletaImage;

    @FXML
    private ImageView marcoImage;

    @FXML
    private Button btnGirar;

    @FXML
    private Button btnReturn;

    @FXML
    private Label resultadoLabel;

    @FXML
    private Label tituloRuleta;

    private final List<String> trucos = List.of(
            "Susto"
    );

    private final List<String> tratos = List.of(
            "Caramelo"
    );

    private final String[] segmentos = {
            "TRATO", "TRATO", "TRUCO", "TRATO",
            "TRUCO", "TRATO", "TRUCO", "TRUCO"
    };

    private final Random random = new Random();

    public void setDatosParticipante(String nombre, String apellidos, String curso) {
        if (tituloRuleta != null) {
            tituloRuleta.setText("🎃 " + nombre + " " + apellidos + " (" + curso + ")");
        }
    }

    @FXML
    public void initialize() {
        try {
            Image fondo = new Image(getClass().getResource("/org/example/tarea_modulo5_halloween/fondoRuleta.png").toExternalForm());
            Image ruleta = new Image(getClass().getResource("/org/example/tarea_modulo5_halloween/ParteInteriorRuleta.png").toExternalForm());
            Image marco = new Image(getClass().getResource("/org/example/tarea_modulo5_halloween/MarcoRuleta.png").toExternalForm());

            fondoImage.setImage(fondo);
            ruletaImage.setImage(ruleta);
            marcoImage.setImage(marco);
        } catch (Exception e) {
            System.err.println("⚠️ Error al cargar imágenes: " + e.getMessage());
        }
    }

    @FXML
    private void girarRuleta() {
        btnGirar.setDisable(true);
        resultadoLabel.setText("");

        // Reiniciar rotación
        ruletaImage.setRotate(0);

        int vueltas = 3;
        int anguloExtra = random.nextInt(360);
        int anguloFinal = 360 * vueltas + anguloExtra;

        RotateTransition rt = new RotateTransition(Duration.seconds(3), ruletaImage);
        rt.setByAngle(anguloFinal);
        rt.setInterpolator(Interpolator.EASE_OUT);
        rt.setOnFinished(e -> mostrarResultado(anguloFinal));
        rt.play();
    }


    private void mostrarResultado(int anguloFinal) {
        int anguloRelativo = anguloFinal % 360;
        int segmentoIndex = anguloRelativo / 45;

        // Alternancia: par = TRUCO, impar = TRATO
        boolean esTruco = segmentoIndex % 2 == 0;

        String tipo = esTruco ? "TRUCO" : "TRATO";
        String detalle = esTruco
                ? trucos.get(random.nextInt(trucos.size()))
                : tratos.get(random.nextInt(tratos.size()));

        resultadoLabel.setText(tipo + ": " + detalle);
        btnGirar.setDisable(false);
    }

    @FXML
    private void volverAlTunel() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("entradaTunel.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("Halloween.css").toExternalForm());

            Stage stage = (Stage) btnReturn.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.err.println("⚠️ Error al volver a la pantalla de entrada: " + e.getMessage());
        }
    }

}







