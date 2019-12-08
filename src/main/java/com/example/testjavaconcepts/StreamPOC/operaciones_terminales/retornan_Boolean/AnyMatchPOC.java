package com.example.testjavaconcepts.StreamPOC.operaciones_terminales.retornan_Boolean;

import com.example.testjavaconcepts.StreamPOC.Persona;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class AnyMatchPOC {
    public static void main(String[] args) {
        List<Persona> personas = Arrays.asList(
                new Persona("Andres","Sati"),
                new Persona("Esteban","Briceno"),
                new Persona("Andres","Briceno"),
                new Persona("Juan","Perez"));

        Boolean b = m1(personas);
        System.out.println(b);
    }

    // Chequear si alguna de las personas cumple que su apellido comienza con B
    private static Boolean m1(List<Persona> list){
        Predicate<Persona> predicate = (persona) -> persona.getApellido().startsWith("B");
        Boolean b = list.stream()
                .anyMatch(predicate);
        return b;
    }
}
