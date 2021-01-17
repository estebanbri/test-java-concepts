package com.example.testjavaconcepts.DesignPatternsPOC.creacionales.Factory_Method.ejemplo_abstracto;

import com.example.testjavaconcepts.DesignPatternsPOC.creacionales.Factory_Method.ejemplo_abstracto.patron.Factory;
import com.example.testjavaconcepts.DesignPatternsPOC.creacionales.Factory_Method.ejemplo_abstracto.patron.product.IProduct;

public class Cliente {
    public static void main(String[] args) {

        String productType = "A";
        //String productType = "B";

        IProduct product = Factory.crearProducto(productType);

    }
}
