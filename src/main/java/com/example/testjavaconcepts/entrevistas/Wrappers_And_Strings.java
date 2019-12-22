package com.example.testjavaconcepts.entrevistas;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Wrappers_And_Strings {

    @Test // int -> String
    public void De_int_A_String__Usando_toString(){
        String str = Integer.toString(25);
        assertThat(str, is("25"));
    }

    @Test // String -> int
    public void De_String_A_int__Usando_parseInt(){
        Map<String, String> lista = new ConcurrentHashMap<>();
        int numero = Integer.parseInt("25");
        assertThat(numero, is(25));
    }

    @Test // String -> Integer
    public void De_String_A_Integer__Usando_valueOf(){
        Integer numero = Integer.valueOf("25");
        assertThat(numero, is(25));
    }

    @Test // int -> Integer (BOXING)
    public void De_int_A_Integer__Usando_valueOf(){
        Integer numero = Integer.valueOf(25);
        assertThat(numero, is(25));
    }

    @Test // int -> Integer (UNBOXING)
    public void De_Integer_A_int__Usando_valueOf(){
        Integer numero = Integer.valueOf(25);
        assertThat(numero, is(25));
    }
}
