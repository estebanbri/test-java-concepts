package com.example.testjavaconcepts.StreamPOC.operaciones_terminales.retorna_int;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class SumPOC {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(2,4,8,10);

        int suma1 = m1(numeros);
        System.out.println(suma1);

        int suma2 = m2(IntStream.of(2,4,6));
        System.out.println(suma2);

    }
    // Alternativa 1: si tenes un Stream<Integer> usar mapToInt(x->x) ó mapToInt(Integer::intValue)
    // sum() funciona sobre stream de int primitivos no sobre Stream<Integer>
    private static int m1(List<Integer> numeros){
        int suma =  numeros.stream()
                .mapToInt(x->x)
                .sum();
        return suma;
    }

    // Alternativa 2: teniendo un stream de int primitive values usando IntStream
    private static int m2(IntStream numeros){
        int suma =  numeros
                .sum();
        return suma;
    }
}
