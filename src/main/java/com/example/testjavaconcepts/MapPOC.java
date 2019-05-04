package com.example.testjavaconcepts;

import java.util.HashMap;
import java.util.Map;

public class MapPOC {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap(); // recorda que la key no puede repetirse en un Map
        map.put("Fruta", "Manzana");
        map.put("Color", "Rojo");
        recorrerMapPOC1(map);
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
