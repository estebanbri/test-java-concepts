package com.example.testjavaconcepts.IOPoc.nio;

import java.io.IOException;
import java.nio.file.*;


public class I_ConocerMimeTypeDeArchivo {

    public static void main(String[] args) throws IOException {
        Archivo archivo = new Archivo();
        archivo.mostrarMymeType();
    }

    private static class Archivo  {
        private final Path filePath = Paths.get(System.getProperty("user.home"), "Downloads", "logfiles", "log-2020-07-25.txt");

        // Returns true if file was succesfully process otherwise false
        public boolean mostrarMymeType() throws IOException {
            if(Files.notExists(filePath)){
                System.err.format("%s no existe\n", filePath.toAbsolutePath());
                return false;
            }
           String mymeType = Files.probeContentType(filePath);
           System.out.println(mymeType);
           return true;
        }
    }

}
