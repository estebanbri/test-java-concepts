package com.example.testjavaconcepts.StreamPOC.CreacionStreams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreacionPOC {
    public static void main(String[] args) throws IOException {
//        Stream<String> stream1 = m1();
//        stream1.forEach(System.out::println);
//
//        int[] numeros = new int[]{2,4,6};
//        IntStream stream2 = m2(numeros);
//        stream2.forEach(System.out::println);

//        Stream<String> stream3 = m3();
//        stream3.forEach(System.out::println);

//        Stream<String> stream4 = m4();
//        stream4.forEach(System.out::println);

//        Stream<Integer> stream5 = m5();
//        stream5.forEach(System.out::println);

//        Stream<Double> stream6 = m6();
//        stream6.forEach(System.out::println);
//
//        Stream<Integer> stream7 = m7();
//        stream7.forEach(System.out::println);

        IntStream stream8 = m8();
        stream8.forEach(System.out::println);
    }

    // Streams from values
    private static Stream<String> m1(){
        Stream<String> stream = Stream.of("Hola","Esteban","Como","Estas","?");
        return stream;
    }

    // Streams from arrays
    private static IntStream m2(int[] numeros){
        IntStream stream = Arrays.stream(numeros);
        return stream;
    }

    // Streams from files y obtener un Stream<String> de cada linea del archivo
    private static Stream<String> m3() throws IOException {
        Path path = Paths.get("C:\\Users\\esteb\\IdeaProjects\\test-java-concepts\\a.txt");
        Stream<String> lineas = Files.lines(path);
        return lineas;
    }

    // Streams from files y obtener un Stream<String> de palabras contenidas en cada linea
    private static Stream<String> m4() throws IOException {
        Path path = Paths.get("C:\\Users\\esteb\\IdeaProjects\\test-java-concepts\\a.txt");
        Stream<String> lineas = Files.lines(path);
        Stream<String> palabras = lineas.flatMap(linea -> Arrays.stream(linea.split(" ")));
        return palabras;
    }

    // Streams from function: iterate()
    private static Stream<Integer> m5()  {
        Stream<Integer> stream = Stream.iterate(0, n -> n + 2)
                        .limit(5);
        return stream;
    }

    // Streams from function: generate()
    private static Stream<Double> m6()  {
        Stream<Double> stream = Stream.generate(Math::random)
                .limit(5);
        return stream;
    }

    // Streams from function: generate()
    private static Stream<Integer> m7()  {
        Stream<Integer> stream = Stream.generate(() -> 2)
                .limit(5);
        return stream;
    }

    // Streams from int primities range: range(min incluido, max no incluido) : 1,2,3,4   | rangeClosed(1,5) : 1,2,3,4,5
    private static IntStream m8()  {
        IntStream stream = IntStream.range(1,5);
        return stream;
    }

}
