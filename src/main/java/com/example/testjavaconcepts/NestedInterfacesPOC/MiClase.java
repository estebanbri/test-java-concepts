package com.example.testjavaconcepts.NestedInterfacesPOC;

public class MiClase implements A.B {
    @Override
    public void m2() {
        System.out.println("Implementacion de m2() de la inner interface B");
    }
}
