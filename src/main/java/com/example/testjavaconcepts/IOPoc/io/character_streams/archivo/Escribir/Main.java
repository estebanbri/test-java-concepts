package com.example.testjavaconcepts.IOPoc.io.character_streams.archivo.Escribir;

// Alternativa 1: OutputStreamWriter(character_streams) + FileOutputStream(byte_streams)
// Alternativa 2: FileWriter(character_streams) extends OutputStreamWriter(character_streams) -> Lo que hicieron es meter el codigo de FileOutputStream dentro de FileWriter asi no tenes que wrappearlo mas como vemos en la alternativa 1
// Alternativa 3: PrintWriter(character_streams)

// Recomienda a Alternativa 1 y 2 wrapearlo en un BufferedWriter
// - Ventaja 1: newLine() -> salto de linea con newLine() (sino en Windows tenes que poner '\r\n')
// - Ventaja 2: bufferizacion -> para darle la capacidad de bufferizacion asi escribe recien cuando se llena el buffer local

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        OutputStreamWriterPOC_MEJORADO();
        FileWriterPOC_MEJORADO();
        PrintWriterWriterPOC();
    }

    // Alternativa 1a: OutputStreamWriter
    public static void OutputStreamWriterPOC1() throws IOException {
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(new File("a1.txt")));
        osw.write("---Linea 1 OutputStreamWriter---");
        osw.write("\r\n---Linea 2 OutputStreamWriter---");
        osw.close();
    }

    // Alternativa 1b: OutputStreamWriter (+ BufferedWriter)
    public static void OutputStreamWriterPOC_MEJORADO() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("a2.txt"))));
        bw.write("---Linea 1 OutputStreamWriter (+ BufferWriter)---");
        bw.newLine();
        bw.write("---Linea 2 OutputStreamWriter (+ BufferWriter)---");
        bw.close();
    }

    // Alternativa 2a: FileWriter
    public static void FileWriterPOC1() throws IOException {
        FileWriter fw = new FileWriter(new File("b1.txt"));
        fw.write("---Linea 1 FileWriter ---");
        fw.write("\r\n---Linea 2 FileWriter ---");
        fw.close();
    }

    // Alternativa 2b: FileWriter (+ BufferedWriter)
    public static void FileWriterPOC_MEJORADO() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("b2.txt")));
        bw.write("---Linea 1 FileWriter (+ BufferWriter) ---");
        bw.newLine();
        bw.write("---Linea 2 FileWriter (+ BufferWriter) ---");
        bw.close();
    }

    // Alternativa 3: PrintWriter (mas simple)
    public static void PrintWriterWriterPOC() throws IOException {
        PrintWriter pw = new PrintWriter(new File("c.txt"));
        pw.println("---Linea 1 PrintWriter ---");
        pw.println("---Linea 2 PrintWriter ---");
        pw.close();
    }

}
