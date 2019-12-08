package com.example.testjavaconcepts.CollectionsJava;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        ////////////////////////
        // equals() + hashCode()
        ///////////////////////

        // Paso 1: Implementar  -   equals()   -  ya que no admite KEY's repetidas

            // No importa el orden (cada elemento va a ser ubicado segun el hash de la key(
              Map<Persona, String> hashmap = new HashMap();
              Persona OBJ_KEY1 = new Persona("Raul", "Perez");
              Persona OBJ_KEY2 = new Persona("Esteban", "Briceno");
              hashmap.put(OBJ_KEY1, "AUSENTE");
              hashmap.put(OBJ_KEY2, "AUSENTE");
              System.out.println(hashmap);
            // ORDEN DE INSERCION
//            Map<Persona, String> linkedHashMap = new LinkedHashMap();
//            Persona OBJ_KEY1 = new Persona("Raul", "Perez");
//            Persona OBJ_KEY2 = new Persona("Esteban", "Briceno");
//            linkedHashMap.put(OBJ_KEY1, "AUSENTE");
//            linkedHashMap.put(OBJ_KEY2, "AUSENTE");
//
        //////////////////////////////////////
        // equals() + hashCode() + compareTo()
        //////////////////////////////////////

        // Paso 2: MUST IMPLEMENTAR Comparable<Persona> comparateTo()
        // ORDEN DADO POR LA KEY
//        Map<Persona, String> treeMap = new TreeMap();
//        Persona OBJ_KEY1 = new Persona("Raul", "Perez");
//        Persona OBJ_KEY2 = new Persona("Esteban", "Briceno");
//        treeMap.put(OBJ_KEY1, "AUSENTE");
//        treeMap.put(OBJ_KEY2, "AUSENTE");


    }

    public static void m1(){

    }


}
