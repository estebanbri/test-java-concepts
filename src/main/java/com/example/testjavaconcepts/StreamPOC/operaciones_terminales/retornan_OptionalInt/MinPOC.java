package com.example.testjavaconcepts.StreamPOC.operaciones_terminales.retornan_OptionalInt;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class MinPOC {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(2,4,1,10);

        OptionalInt minimo1 = m1(numeros);
        minimo1.ifPresent(System.out::println);

        OptionalInt minimo2 = m2(IntStream.of(2,0,6));
        minimo2.ifPresent(System.out::println);

    }
    // Alternativa 1: si tenes un Stream<Integer> usar mapToInt(x->x) ó mapToInt(Integer::intValue)
    // sum() funciona sobre stream de int primitivos no sobre Stream<Integer>
    private static OptionalInt m1(List<Integer> numeros){
        OptionalInt minimo =  numeros.stream()
                .mapToInt(x->x)
                .min();
        return minimo;
    }

    // Alternativa 2: teniendo un stream de int primitive values usando IntStream
    private static OptionalInt m2(IntStream numeros){
        OptionalInt minimo =  numeros
                .min();
        return minimo;
    }
}
