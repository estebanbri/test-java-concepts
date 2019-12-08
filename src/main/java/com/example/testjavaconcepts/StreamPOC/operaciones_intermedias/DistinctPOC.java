package com.example.testjavaconcepts.StreamPOC.operaciones_intermedias;

import com.example.testjavaconcepts.StreamPOC.Persona;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class DistinctPOC {
    public static void main(String[] args) {
        List<Persona> personas = Arrays.asList(
                new Persona("Andres","Sati"),
                new Persona("Esteban","Briceno"),
                new Persona("Esteban","Briceno"),
                new Persona("Andres","Briceno"),
                new Persona("Juan","Perez"));

        Stream<Persona> stream2 = m2(personas);
        stream2.forEach(System.out::println);
    }

    // filtrar las personas sin personas repetidas (according to equals and hashcode)
    private static Stream<Persona> m2(List<Persona> list){
        Stream<Persona> stream = list.stream()
                .distinct();
        return stream;
    }
}
