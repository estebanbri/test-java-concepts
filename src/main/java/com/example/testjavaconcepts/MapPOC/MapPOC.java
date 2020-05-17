package com.example.testjavaconcepts.MapPOC;

import java.util.HashMap;
import java.util.Map;

//  |   putIfAbsent(K key, V value)   VS   computeIfAbsent(K key, Function<T,V> f)   |
// Sirven para lo mimso 
// putIfAbsent y computeIfAbsent terminan sirviendo para lo mismo para agregar entries a tu map. Pero tienen una pequeña diferencia 
// putIfAbsent primero crea el objeto de value especificado y despues chequea si la key existe, en caso de que la key ya exista
// no lo va a agregar como entry en el map, pero la desventaja es que te creo el objeto anyway en el heap.
// En cambio computeIfAbsent al aceptar una lamda exp como argumento primero valida si existe la key en el map y no ejecuta la lamda
// en caso de que ya exista la key, por ende no te crea al pedo el objeto en el heap.

//  |   compute(K key, BiFunction<T, U, R> f)   VS   computeIfPresent(K key, BiFunction<T, U, R> f)   |
// Sirven para lo mimso, lo unico que computeIfPresent te salva de nullpointer en caso de que no exista la key.

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
