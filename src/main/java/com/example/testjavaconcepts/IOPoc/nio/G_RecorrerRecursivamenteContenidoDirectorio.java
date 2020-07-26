package com.example.testjavaconcepts.IOPoc.nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

import static java.nio.file.FileVisitResult.CONTINUE;

public class G_RecorrerRecursivamenteContenidoDirectorio {
    public static void main(String[] args) throws IOException {
        Archivo archivo = new Archivo();
        archivo.recorrerRecursivamente();
    }

    private static class Archivo extends SimpleFileVisitor<Path> {
        private final Path dirPath = Paths.get(System.getProperty("user.home"), "Downloads", "logfiles");

        // Returns true if file was succesfully process otherwise false
        public boolean recorrerRecursivamente() throws IOException {
            if(!Files.isDirectory(dirPath)){
                System.err.format("%s is not a directory\n", dirPath.toAbsolutePath());
                return false;
            }
            Files.walkFileTree(dirPath, new SimpleFileVisitor<Path>(){
                // Print each file visited and size info.
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    System.out.format("Regular file: %s ", file);
                    System.out.println("(" + attrs.size() + "bytes)");
                    return CONTINUE;
                }

                // Print each directory visited.
                @Override
                public FileVisitResult postVisitDirectory(Path dir,
                                                          IOException exc) {
                    System.out.format("Directory: %s%n", dir);
                    return CONTINUE;
                }
            });
            return true;
        }
    }
}
