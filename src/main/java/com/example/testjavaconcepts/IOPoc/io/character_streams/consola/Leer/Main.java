package com.example.testjavaconcepts.IOPoc.io.character_streams.consola.Leer;

// Alternativa 1 : Scanner
    // - next() : el scanner lee hasta encontrar un ESPACIO. Ej: String s = sc.next("Hola Como estas?"); ( contenido de s : "Hola" )
    // - nextLine() : el scanner lee hasta encontrar un SALTO DE LINEA. Ej: String s = sc.nextLine() ("Hola Como estas?"); ( contenido de s : "Hola Como estas?")
// Alternativa 2 : InputStreamReader (+ BufferedReader)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ScannerPOC();
        BufferedReaderPOC();
    }
    // Alternativa 1: Scanner
    public static void ScannerPOC(){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(input);
    }
    // Alternativa 2: InputStreamReader (+ BufferedReader)
    public static void BufferedReaderPOC() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(input);
    }
}
