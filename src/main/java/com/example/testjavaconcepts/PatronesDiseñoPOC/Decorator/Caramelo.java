package com.example.testjavaconcepts.PatronesDiseñoPOC.Decorator;

public class Caramelo extends Decorador {

    Bebida bebida; // Expresso

    public Caramelo(Bebida bebida){
        this.bebida = bebida;
    }

    @Override
    public int cost() {
        System.out.println("Agregando costo: CARAMELO");
        return bebida.cost() + 22;   // bebida.cost() ejecuta el metodo cost() dentro de Expreso
    }
}
