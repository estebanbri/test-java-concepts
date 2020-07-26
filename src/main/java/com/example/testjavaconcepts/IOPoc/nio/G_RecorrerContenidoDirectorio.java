package com.example.testjavaconcepts.IOPoc.nio;

import java.io.IOException;
import java.nio.file.*;

public class G_RecorrerContenidoDirectorio {
    public static void main(String[] args) throws IOException {
        Archivo archivo = new Archivo();
        archivo.recorrer();
    }

    private static class Archivo {
        private final Path dirPath = Paths.get(System.getProperty("user.home"), "Downloads", "logfiles");

        // Returns true if file was succesfully process otherwise false
        public boolean recorrer() throws IOException {
            if(!Files.isDirectory(dirPath)){
                System.err.format("%s is not a directory\n", dirPath.toAbsolutePath());
                return false;
            }
            try(DirectoryStream<Path> stream = Files.newDirectoryStream(dirPath)){
                for(Path path : stream){
                    System.out.println(path.getFileName());
                }
            }
            return true;
        }
    }
}
