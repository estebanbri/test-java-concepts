package com.example.testjavaconcepts.StreamPOC.operaciones_terminales.retornan_Optional;

import com.example.testjavaconcepts.StreamPOC.Persona;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class FindFirstPOC {
    public static void main(String[] args) {
        List<Persona> personas = Arrays.asList(
                new Persona("Andres","Sati"),
                new Persona("Esteban","Briceno"),
                new Persona("Andres","Briceno"),
                new Persona("Juan","Perez"));

        Optional<Persona> optional = m1(personas);
        optional.ifPresent(System.out::println);
    }

    // Retornar la primera persona dentro del stream
    // cuando no importa que elemento retornar usa findAny ya que hace funcionar mejor en paralelismo que findFirst
    private static Optional<Persona> m1(List<Persona> list){
        Optional<Persona> optional = list.stream()
                .findFirst();
        return optional;
    }
}
