package com.example.testjavaconcepts.StreamPOC;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Creacion {
    public static void main(String[] args) {

    }

    public static void creandoStreamPOC1(){ // Stream.of(T... value)
        Stream<String> stream = Stream.of("Audi","Fiat", "VW");
    }

    public static void creandoStreamPOC2(){ // Arrays.stream(T[] arr)
        String[] frutas = new String[]{"Manzana", "Banana", "Naranja"};
        Stream<String> stream = Arrays.stream(frutas);
    }

    public static void creandoStreamPOC3A(){ // A partir de Collection
        List<Integer> list = new ArrayList();
        Stream<Integer> stream = list.stream();
    }

    public static void creandoStreamPOC4(){ // A partir de Collection
        Stream<String> stream = Stream.<String>builder()
                                                .add("Rojo")
                                                .add("Verde")
                                                .build();
    }

    public static void creandoStreamPOC5(){ // Stream.generate(Supplier)
        Supplier<String> supplier = () -> "Hola";
        Stream<String> stream = Stream.generate(supplier).limit(5);
    }

    public static void creandoStreamPOC6(){ // Stream.iterate(n, funcion(n))
        Stream<Integer> stream = Stream.iterate(0, n -> n + 2).limit(5);
    }

    public static void creandoStreamPOC7() throws IOException { // Files.lines(path)
        Path path = Paths.get("mi_archivo.txt");
        Stream<String> stream = Files.lines(path);
    }

    /**
     * Como Stream es una interface que hace uso de generics,
     * no puede utilizar tipos de datos primitivos por este motivo
     * es que el que el paquete java.util.stream nos provee interfaces
     * para poder manejarlos como por ejemplo:
     * IntStream, LongStream, DoubleStream
     */
    public static void creandoStreamPOC8(){ // IntStream.range(startIndex, lastIndex)
        IntStream stream = IntStream.range(1,5);
    }
}
