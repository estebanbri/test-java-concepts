package com.example.testjavaconcepts.PatronesDiseñoPOC.Decorator;

public class Expresso extends Bebida {

    @Override
    public int cost() {
        System.out.println("Agregando costo: CAFE EXPRESSO");
        return 10;  // costo base
    }
}
