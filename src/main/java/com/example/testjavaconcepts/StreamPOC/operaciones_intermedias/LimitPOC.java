package com.example.testjavaconcepts.StreamPOC.operaciones_intermedias;

import com.example.testjavaconcepts.StreamPOC.Persona;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LimitPOC {
    public static void main(String[] args) {
        List<Persona> personas = Arrays.asList(
                new Persona("Andres","Sati"),
                new Persona("Esteban","Briceno"),
                new Persona("Andres","Briceno"),
                new Persona("Juan","Perez"));

        Stream<Persona> stream2 = m1(personas);
        stream2.forEach(System.out::println);
    }

    // limitar el resultado a dos personas
    private static Stream<Persona> m1(List<Persona> list){
        Stream<Persona> stream = list.stream()
                .limit(2);
        return stream;
    }
}
