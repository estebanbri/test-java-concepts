package com.example.testjavaconcepts.IOPoc.nio;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;

public class C_EscribirTexto {

    public static void main(String[] args) throws IOException {
        Archivo archivo = new Archivo();
        archivo.escribir("log-".concat(LocalDate.now().toString()).concat(".txt"),"Hola Mundo2!");
    }

    private static class Archivo {
        private final Path path = Paths.get(System.getProperty("user.home"), "Downloads", "logfiles"); // file name

        // Returns true if file was succesfully process otherwise false
        public boolean escribir(String nombreArchivo, String texto) throws IOException {
            Path filePath = path.resolve(nombreArchivo);
            StandardOpenOption standardOpenOption = Files.exists(filePath)?
                    StandardOpenOption.APPEND :
                    StandardOpenOption.WRITE; // Write es el valor default

            try(BufferedWriter bw = Files.newBufferedWriter(filePath, standardOpenOption)){
                    bw.newLine();
                    bw.write(texto);
            }

            return true;
        }
    }
}
