package com.example.testjavaconcepts.StreamPOC.operaciones_terminales.retornan_T;

import com.example.testjavaconcepts.StreamPOC.Persona;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

public class ReducePOC {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(2,4,8,10);

        Integer suma = m1(numeros);
        System.out.println(suma);

        Integer multiplicacion = m2(numeros);
        System.out.println(multiplicacion);
    }

    private static Integer m1(List<Integer> numeros){
        BinaryOperator<Integer> binaryOperator = (a, b)-> a + b;  // new Java 8: Integer::sum()
        Integer suma =  numeros.stream()
                .reduce(0, binaryOperator);
        return suma;
    }

    private static Integer m2(List<Integer> numeros){
        BinaryOperator<Integer> binaryOperator = (a, b)-> a * b;
        Integer multiplicacion =  numeros.stream()
                .reduce(1, binaryOperator);
        return multiplicacion;
    }
}
