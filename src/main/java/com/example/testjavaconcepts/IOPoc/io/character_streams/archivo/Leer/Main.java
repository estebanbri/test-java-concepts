package com.example.testjavaconcepts.IOPoc.io.character_streams.archivo.Leer;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args ) throws IOException {
        InputStreamReaderPOC();
        InputStreamReaderPOC_MEJORADO();
    }

    // Alternativa 1a: InputStreamReaderPOC
    public static void InputStreamReaderPOC() throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream((new File("a2.txt"))));
        int num;
        while((num = isr.read()) != -1){
            char caracter = (char)num;
            if(caracter=='\n'){
                System.out.println();
                continue;
            }
            System.out.print(caracter);
        }
        isr.close();
    }

    // Alternativa 1b: OutputStreamReader (+ BufferedReader)
    public static void InputStreamReaderPOC_MEJORADO() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream((new File("a2.txt")))));
        String linea;
        while((linea = br.readLine()) != null){
            System.out.println(linea);
        }
        br.close();
    }

    // Alternativa 2a: FileReader
    public static void FileReaderPOC1() throws IOException {
        FileReader fr = new FileReader(new File("b1.txt"));
        int num;
        while((num = fr.read()) != -1){
            char caracter = (char)num;
            if(caracter=='\n'){
                System.out.println();
                continue;
            }
            System.out.print(caracter);
        }
        fr.close();
    }

    // Alternativa 2b: FileReader (+ BufferedReader)
    public static void FileReaderPOC_MEJORADO() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("b2.txt")));
        String linea;
        while((linea = br.readLine()) != null){
            System.out.println(linea);
        }
        br.close();
    }
    // Alternativa 3: Scanner
    public static void ScannerPOC() throws IOException{
        Scanner sc = new Scanner(new File("b3.txt"));
        while(sc.hasNextLine()){
            String linea = sc.nextLine();
            System.out.println(linea);
        }
    }

}
