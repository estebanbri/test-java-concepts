package com.example.testjavaconcepts.IOPoc.nio;

import java.io.File;
import java.nio.file.FileSystems;

public class H_SeparadorDeRutas {
    public static void main(String[] args) {
        // The path separator for POSIX file systems (unix) is the forward slash, /,
        // and for Microsoft Windows is the backslash, \.
        // Other file systems might use other delimiters.
        // To retrieve the Path separator for the default file system,
        // you can use one of the following approaches

        // Opcion 1
        String separador1 = File.separator;

        // Opcion 1
        String separador2 = FileSystems.getDefault().getSeparator();

        System.out.println(separador1);
        System.out.println(separador2);
    }
}
