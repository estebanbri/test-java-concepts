package com.example.testjavaconcepts.StreamPOC.operaciones_terminales.retorna_long;

import com.example.testjavaconcepts.StreamPOC.Persona;

import java.util.Arrays;
import java.util.List;

public class CountPOC {
    public static void main(String[] args) {
        List<Persona> personas = Arrays.asList(
                new Persona("Andres","Sati"),
                new Persona("Esteban","Briceno"),
                new Persona("Andres","Briceno"),
                new Persona("Juan","Perez"));

        long cantidad = m1(personas);
        System.out.println(cantidad);
    }

    // Cantidad de elementos en el stream
    private static long m1(List<Persona> list){
        long cantidad = list.stream()
                .count();
        return cantidad;
    }
}
