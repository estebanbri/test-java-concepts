package com.example.testjavaconcepts.PatronesDiseñoPOC.Decorator;

public class Caramelo extends Decorador {

    Bebida bebida;

    public Caramelo(Bebida bebida){
        this.bebida = bebida;
    }

    @Override
    public int cost() {
        System.out.println("Add On = Caramelo | $22");
        return bebida.cost() + 22;
    }
}
