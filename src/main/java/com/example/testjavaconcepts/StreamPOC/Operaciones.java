package com.example.testjavaconcepts.StreamPOC;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class Operaciones {

    public static void main(String[] args) {
        List<Persona> list = new ArrayList();
        list.add(new Persona("Esteban", "Briceo"));
        list.add(new Persona("Andres", "Sati"));
//        List<List<Persona>> listOfList = new ArrayList();
//        listOfList.add(list);
//        listOfList.add(list);

    }

    /**
     *  Operaciones intermedias
     */

    // map()
    public static Stream<String> mapPOC(List<Persona> list){
        Stream<Persona> stream1 = list.stream();
        Stream<String> stream2 = stream1.map(persona -> persona.getNombre());
        return stream2;
    }

    // filter()
    public static Stream<Persona> filterPOC(List<Persona> list){
        Stream<Persona> stream1 = list.stream();
        Stream<Persona> stream2 = stream1.filter(persona-> "Esteban".equals(persona.getNombre()));
        return stream2;
    }

    //flatMap()
    public static Stream<Persona> flatMapPOC(List<List<Persona>> listofList){
        Stream<List<Persona>> stream1 = listofList.stream();
        Stream<Persona> stream2 = stream1.flatMap((list)-> list.stream()); // Collecion::stream
        return stream2;
    }

    //distinct()
    //sorted()
    //peek()

    //limit()
    public static Stream<String> limitPOC(){
        Stream<String> stream1 = Stream.of("A","B","C");
        Stream<String> stream2 = stream1.limit(2);
        return stream2;
    }
    //skip()
    public static Stream<String> skipPOC(){
        Stream<String> stream1 = Stream.of("A","B","C");
        Stream<String> stream2 = stream1.skip(2);
        return stream2;
    }

    /**
     *  Operaciones terminales
     */
    //forEach()
    //forEachOrdered()
    //toArray()
    //reduce()
    //collect()
    //min()
    //max()
    //count()
    //anyMatch()
    //allMatch()
    //noneMatch()
    //findFirst()
    //findAny()

    public static class Persona{
        private String nombre;
        private String apellido;
        Persona(String nombre, String apellido){ this.nombre = nombre; this.apellido = apellido; }
        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        @Override
        public String toString() { return "Persona{" + "nombre='" + nombre + '\'' + ", apellido='" + apellido + '\'' + '}'; }
    }
}
