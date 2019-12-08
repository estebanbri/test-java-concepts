package com.example.testjavaconcepts.IOPoc.nio;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NIO {
    public static void main(String[] args) throws IOException {

        Path pathFile = Paths.get("file.txt");
        Path pathDir = Paths.get("dir");

        // Crear file
        Files.createFile(pathFile);

        // Crear directory
        //Files.createDirectory(pathDir);

        // Escribir en un archivo usando el metodo write() de BufferedWriter
        BufferedWriter writer = Files.newBufferedWriter(pathFile);
        writer.write("Soy el contenido! ...");

        // Escribir en un archivo usando el metodo write() de Files
        String contenido = "Soy el contenido 2!...";
        byte[] arr = contenido.getBytes();
        Files.write(pathFile, arr);

    }

    public static void m1() throws IOException {
        Path path = Paths.get("");
        Files.createFile(path);
        BufferedWriter bw = Files.newBufferedWriter(path);
        bw.write("hola");
        bw.newLine();

    }
}
