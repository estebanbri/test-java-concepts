package com.example.testjavaconcepts.StreamPOC.operaciones_intermedias;

import com.example.testjavaconcepts.StreamPOC.Persona;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FilterPOC {

        public static void main(String[] args) {
            List<Persona> personas = Arrays.asList(
                    new Persona("Andres","Sati"),
                    new Persona("Esteban","Briceno"),
                    new Persona("Andres","Briceno"),
                    new Persona("Juan","Perez"));

//            Stream<Persona> stream1 = m1(personas);
//            stream1.forEach(System.out::println);

//            Stream<Persona> stream2 = m2(personas);
//            stream2.forEach(System.out::println);
        }

        // filtrar personas con apellido que comienzan con 'B'
        private static Stream<Persona> m1(List<Persona> list){
            Predicate<Persona> predicate1 = (persona) -> persona.getApellido().startsWith("B");
            Stream<Persona> stream = list.stream()
                    .filter(predicate1);
            return stream;
        }

        // filtrar personas con apellido que comienzan con 'A' OR 'B'
        private static Stream<Persona> m2(List<Persona> list){
            Predicate<Persona> predicate1 = (persona) -> persona.getApellido().startsWith("A");
            Predicate<Persona> predicate2 = (persona) -> persona.getApellido().startsWith("B");
            Stream<Persona> stream = list.stream()
                    .filter(predicate1.or(predicate2));
            return stream;
        }

}
