package com.example.testjavaconcepts.DesignPatternsPOC.creacionales.Factory_Method.ejemplo_real;

import com.example.testjavaconcepts.DesignPatternsPOC.creacionales.Factory_Method.ejemplo_real.patron.MonedaFactory;
import com.example.testjavaconcepts.DesignPatternsPOC.creacionales.Factory_Method.ejemplo_real.patron.product.IMoneda;

public class Cliente {
    public static void main(String[] args) {

        String pais = "ARGENTINA";
        //String pais = "CHILE";

        IMoneda product = MonedaFactory.crearMoneda(pais);
        String productDescription = product.getDescription();
        System.out.println(productDescription);
    }
}
