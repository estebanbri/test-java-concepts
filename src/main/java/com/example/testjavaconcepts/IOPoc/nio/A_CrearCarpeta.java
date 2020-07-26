package com.example.testjavaconcepts.IOPoc.nio;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class A_CrearCarpeta {
    public static void main(String[] args) throws IOException {
        Archivo archivo = new Archivo();
        archivo.crearCarpeta("logfiles");
    }

    private static class Archivo {
        private final Path path = Paths.get(System.getProperty("user.home"),"Downloads"); // root path

        public boolean crearCarpeta(String nombreCarpeta) throws IOException {
            Path dirPath = path.resolve(nombreCarpeta); // resolve te permite armar Path sin tener que armarlos a mano usando Strings concat por ej
            if(Files.exists(dirPath)){
                System.err.format("%s already exist\n", dirPath.getFileName());
                return false;
            }
            if(!Files.isDirectory(dirPath)){
                System.err.format("%s is not a directory\n", dirPath.getFileName());
            }
            Files.createDirectory(dirPath);
            return  true;
        }

    }
}
