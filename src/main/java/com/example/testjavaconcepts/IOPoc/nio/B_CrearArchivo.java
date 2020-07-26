package com.example.testjavaconcepts.IOPoc.nio;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

public class B_CrearArchivo {
    public static void main(String[] args) throws IOException {
        Archivo archivo = new Archivo();
        archivo.crearArchivo("log-".concat(LocalDate.now().toString().concat(".txt")));

    }

    private static class Archivo {
        private final Path path = Paths.get(System.getProperty("user.home"), "Downloads", "logfiles");

        public boolean crearArchivo(String nombreArchivo) throws IOException {
            Path dirPath = path.resolve(nombreArchivo);
            if(Files.exists(dirPath)){
                System.err.format("%s already exist\n", dirPath.getFileName());
                return false;
            }
            Files.createFile(dirPath.resolve(nombreArchivo));
            return true;
        }

    }
}
