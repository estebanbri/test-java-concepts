package com.example.testjavaconcepts.StreamPOC.operaciones_intermedias;

import com.example.testjavaconcepts.StreamPOC.Persona;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class SkipPOC {
    public static void main(String[] args) {
        List<Persona> personas = Arrays.asList(
                new Persona("Andres","Sati"),
                new Persona("Esteban","Briceno"),
                new Persona("Andres","Briceno"),
                new Persona("Juan","Perez"));

        Stream<Persona> stream2 = m1(personas);
        stream2.forEach(System.out::println);
    }

    // skip las 2 primeras personas
    private static Stream<Persona> m1(List<Persona> list){
        Stream<Persona> stream = list.stream()
                .skip(2);
        return stream;
    }
}
