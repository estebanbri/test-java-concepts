package com.example.testjavaconcepts.InmutablePOC;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ////////////////////////////////////

        SimpleInmutable obj = new SimpleInmutable("Hola", 123);

        String s = obj.getStr();
        String modifiedStr = s.concat("Chau"); // string al ser inmutable te este concat crea otro objecto nuevo, es decir no modifica el objecto obj

        System.out.println(obj);

        ////////////////////////////////////

        CollectionInmutable obj2 = new CollectionInmutable(Arrays.asList("Hola","Hola","Hola"));

        List<String> list = obj2.getList();

        // list.add("Chau"); // al intentar modificar la lista arroja UnsupportedOperationException gracias a Collections.unmodifiedList

        System.out.println(obj2);

    }
}
