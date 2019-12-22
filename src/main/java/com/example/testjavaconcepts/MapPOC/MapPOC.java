package com.example.testjavaconcepts.MapPOC;

import java.util.HashMap;
import java.util.Map;

public class MapPOC {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("Fruta", "Manzana");
        map.put("Color", "Rojo");

        //String value1 = map.getOrDefault("Color", "NO_EXISTE");
        //System.out.println(value1);

        //String value2 = map.get("11.164.357");
        //System.out.println(value2);


        //recorrerMapPOC1(map);
       // map.compute("Color", (key, oldValue)->  oldValue.concat(", Azul"));
       // System.out.println(map);

        //map.compute("Animal", (key, oldValue)->  oldValue.concat(", Perro"));
        //System.out.println(map);

        //System.out.println(map);
        //map.computeIfAbsent("Animal", key -> "Perro");
        //System.out.println(map);

         //map.computeIfAbsent("Animal", key -> "Gato");
         //System.out.println(map);
        map.replace("Color", "Azul");
        System.out.println(map);

        map.replace("Animal", "Perro");
        System.out.println(map);
    }

    // Java 8
    public static void recorrerMapPOC1(Map<String, String> map){
        map.forEach((k,v)->System.out.println(k + v));
    }

    // Pre Java 8
    public static void recorrerMapPOC2(Map<String, String> map){
        for(Map.Entry<String, String> entry : map.entrySet()){
            System.out.println(entry.getKey() + entry.getValue());
        }
    }

}
