package org.example.tarea_modulo5_halloween;

public class Launcher {
    public static void main(String[] args) {
        // Esta línea llama a la clase que extiende de Application
        // Al no heredar de Application, el JAR no buscará módulos y funcionará por Classpath
        EntradaTunel.main(args);
    }
}