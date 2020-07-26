package com.example.testjavaconcepts.IOPoc.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

public class D_LeerTextoSinUsarBufferedReader {
    public static void main(String[] args) throws IOException {
        Archivo archivo = new Archivo();
        archivo.leer("log-2020-07-25.txt");

    }

    private static class Archivo {
        private final Path path = Paths.get(System.getProperty("user.home"), "Downloads", "logfiles");

        // Returns true if file was succesfully process otherwise false
        public boolean leer(String nombreArchivo) throws IOException {
            Path filePath = path.resolve(nombreArchivo);
            if(Files.notExists(filePath)){
                System.err.format("%s does not exist\n", filePath.getFileName());
                return false;
            }
            Files.readAllLines(filePath)
                    .forEach(System.out::println);
            return true;
        }
    }
}
