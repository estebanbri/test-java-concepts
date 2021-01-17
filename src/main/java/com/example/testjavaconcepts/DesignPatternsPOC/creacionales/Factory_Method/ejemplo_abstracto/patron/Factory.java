package com.example.testjavaconcepts.DesignPatternsPOC.creacionales.Factory_Method.ejemplo_abstracto.patron;

import com.example.testjavaconcepts.DesignPatternsPOC.creacionales.Factory_Method.ejemplo_abstracto.patron.product.IProduct;
import com.example.testjavaconcepts.DesignPatternsPOC.creacionales.Factory_Method.ejemplo_abstracto.patron.product.impl.ProductA;
import com.example.testjavaconcepts.DesignPatternsPOC.creacionales.Factory_Method.ejemplo_abstracto.patron.product.impl.ProductB;

public class Factory {

    public static IProduct crearProducto(String productType){
        switch (productType) {
            case "A" : return new ProductA();
            case "B" : return new ProductB();
            default: return null;
        }
    }

}
