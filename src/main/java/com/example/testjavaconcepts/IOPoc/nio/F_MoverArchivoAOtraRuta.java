package com.example.testjavaconcepts.IOPoc.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class F_MoverArchivoAOtraRuta {
    public static void main(String[] args) throws IOException {
        Archivo archivo = new Archivo();
        archivo.mover();
    }

    private static class Archivo {
        private final Path filePathSource = Paths.get(System.getProperty("user.home"), "Downloads", "logfiles", "log-2020-07-25.txt");
        private final Path filePathTarget = Paths.get(System.getProperty("user.home"), "Downloads", "logfiles","backup","log-2020-07-25-backup.txt");

        // Returns true if file was succesfully process otherwise false
        public boolean mover() throws IOException {
            if(Files.notExists(filePathSource)){
                System.err.format("%s does not exist\n", filePathSource.getFileName());
                return false;
            }
            Files.move(filePathSource, filePathTarget, StandardCopyOption.REPLACE_EXISTING);
            return true;
        }
    }
}
