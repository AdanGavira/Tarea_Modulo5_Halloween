module org.example.tarea_modulo5_halloween {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.tarea_modulo5_halloween to javafx.fxml;
    exports org.example.tarea_modulo5_halloween;
}