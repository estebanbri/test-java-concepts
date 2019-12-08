package com.example.testjavaconcepts.CollectionsJava.Collection.List;

import com.example.testjavaconcepts.CollectionsJava.Collection.List.model.Persona;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A_ArrayList {
    public static void main(String[] args) {

        ArrayList<Persona> personas = new ArrayList<>();

        // add(obj)
        System.out.println("add(obj)");
        personas.add(new Persona("A", "A"));
        personas.add(new Persona("C", "C"));
        personas.add(new Persona("D", "D"));
        System.out.println("Personas: " + personas);
        System.out.println("----");

        // add(index, obj)
        System.out.println("add(index, obj)");
        Persona obj = new Persona("B", "B");
        personas.add(1, obj);
        System.out.println(personas);
        System.out.println("----");

        // remove(index)
        System.out.println("remove(index)");
        Persona personaRemoved = personas.remove(1);
        System.out.println(personaRemoved + " fue removido" );
        System.out.println(personas);
        System.out.println("----");

        // get(index)
        System.out.println("get(2)");
        Persona persona = personas.get(2);
        System.out.println(persona + " se encuentra en la posicion 2");
        System.out.println("----");

        // addAll(Collection)
        System.out.println("addAll(Collection)");
        List<Persona> list = Arrays.asList(
                new Persona("Y", "Y"),
                new Persona("Z", "Z"));
        personas.addAll(list);
        System.out.println(personas);
        System.out.println("----");

        // remove(obj)
        System.out.println("remove(obj) -> requiere equals");
        Persona obj2 = new Persona("C", "C");
        boolean wasRemoved = personas.remove(obj2);
        System.out.println("C C fue removido? " + wasRemoved);
        System.out.println(personas);
        System.out.println("----");

        // contains(obj)
        System.out.println("contains(obj) -> requiere equals");
        Persona objBuscando = new Persona("Z", "Z");
        boolean exists = personas.contains(objBuscando);
        System.out.println("Z Z existe: " + exists);
        System.out.println("----");

        // indexOf(obj)
        System.out.println("indexOf(obj) -> requiere equals");
        Persona objBuscado2 = new Persona("Y", "Y");
        int index = personas.indexOf(objBuscado2);
        System.out.println("Y Y se encuentra en la posicion " + index);
        System.out.println("----");

        // clone() -> Especifico de ArrayList (No esta declarado en la interface List)
        System.out.println("clone() -> method in ArrayList class only not in List");
        ArrayList<Persona> listClone = (ArrayList<Persona>) personas.clone();
        System.out.println("Lista clonada :" + listClone);
        System.out.println("----");

        // clear()
        System.out.println("clear()");
        personas.clear();
        System.out.println(personas);
        System.out.println("----");

        // isEmpty()
        System.out.println("isEmpty()");
        boolean isEmpty = personas.isEmpty();
        System.out.println("Lista esta vacia?: " + isEmpty);
    }
}
