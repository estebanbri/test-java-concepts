package com.example.testjavaconcepts.StreamPOC.operaciones_terminales.retornan_Boolean;

import com.example.testjavaconcepts.StreamPOC.Persona;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class NoneMatch {
    public static void main(String[] args) {
        List<Persona> personas = Arrays.asList(
                new Persona("Andres","Sati"),
                new Persona("Esteban","Briceno"),
                new Persona("Andres","Briceno"),
                new Persona("Juan","Perez"));

        Boolean b = m1(personas);
        System.out.println(b);
    }

    // Chequear si ninguna de las personas cumple que su apellido comienza con X
    private static Boolean m1(List<Persona> list){
        Predicate<Persona> predicate = (persona) -> persona.getApellido().startsWith("X");
        Boolean b = list.stream()
                .noneMatch(predicate);
        return b;
    }
}
