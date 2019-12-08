package com.example.testjavaconcepts.StreamPOC.operaciones_intermedias;

import com.example.testjavaconcepts.StreamPOC.Persona;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class SortedPOC {
    public static void main(String[] args) {
        List<Persona> personas = Arrays.asList(
                new Persona("Andres","Sati"),
                new Persona("Esteban","Briceno"),
                new Persona("Andres","Briceno"),
                new Persona("Juan","Perez"));

//        Stream<Persona> stream1 = m1(personas);
//        stream1.forEach(System.out::println);

        Stream<Persona> stream2 = m2(personas);
        stream2.forEach(System.out::println);
//
//        Stream<Persona> stream3 = m3(personas);
//        stream3.forEach(System.out::println);
    }

    // Retornar stream ordenado segun el compareTo (ordenado por apellido)
    private static Stream<Persona> m1(List<Persona> list){
        Stream<Persona> stream = list.stream()
                .sorted();
        return stream;
    }

    // Retornar stream ordenado segun el compareTo (ordenado por nombre) (FORMA 1 NUEVA)
    private static Stream<Persona> m2(List<Persona> list){
        Stream<Persona> stream = list.stream()
                .sorted(Comparator.comparing(Persona::getNombre));
        return stream;
    }

    // Retornar stream ordenado segun el compareTo (ordenado por nombre) (FORMA 2 sin usar comparing)
    private static Stream<Persona> m3(List<Persona> list){
        Stream<Persona> stream = list.stream()
                .sorted((persona1, persona2)-> persona1.getNombre().compareTo(persona2.getNombre()));
        return stream;
    }
}
