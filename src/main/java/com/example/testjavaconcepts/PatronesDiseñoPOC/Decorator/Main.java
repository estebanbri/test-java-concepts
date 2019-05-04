package com.example.testjavaconcepts.PatronesDiseñoPOC.Decorator;

public class Main {

    public static void main(String[] args) {
        Bebida bebida = new Caramelo(new Expresso());
        System.out.println("Costo total | $" + bebida.cost());
    }
}
