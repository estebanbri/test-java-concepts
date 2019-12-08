package com.example.testjavaconcepts.StreamPOC.operaciones_terminales.retornan_OptionalInt;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class MaxPOC {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(2,4,1,10);

        OptionalInt maximo1 = m1(numeros);
        maximo1.ifPresent(System.out::println);

        OptionalInt maximo2 = m2(IntStream.of(2,0,6));
        maximo2.ifPresent(System.out::println);

    }
    // Alternativa 1: si tenes un Stream<Integer> usar mapToInt(x->x) ó mapToInt(Integer::intValue)
    // max() funciona sobre stream de int primitivos no sobre Stream<Integer>
    private static OptionalInt m1(List<Integer> numeros){
        OptionalInt minimo =  numeros.stream()
                .mapToInt(x->x)
                .max();
        return minimo;
    }

    // Alternativa 2: teniendo un stream de int primitive values usando IntStream
    private static OptionalInt m2(IntStream numeros){
        OptionalInt minimo =  numeros
                .max();
        return minimo;
    }
}
