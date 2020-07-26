package com.example.testjavaconcepts.IOPoc.nio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDate;

public class D_LeerTextoUsandoBufferedReader {
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
            // The try-with-resources statement has the advantage that the compiler automatically generates the code to close the resource(s) when no longer required.
            try(BufferedReader br = Files.newBufferedReader(filePath)){
                String linea;
                while( (linea = br.readLine()) != null ){
                    System.out.println(linea);
                }
            }
            return true;
        }
    }
}
