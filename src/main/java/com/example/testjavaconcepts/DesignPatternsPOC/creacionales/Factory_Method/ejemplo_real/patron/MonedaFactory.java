package com.example.testjavaconcepts.DesignPatternsPOC.creacionales.Factory_Method.ejemplo_real.patron;

import com.example.testjavaconcepts.DesignPatternsPOC.creacionales.Factory_Method.ejemplo_real.patron.product.IMoneda;
import com.example.testjavaconcepts.DesignPatternsPOC.creacionales.Factory_Method.ejemplo_real.patron.product.impl.MonedaARS;
import com.example.testjavaconcepts.DesignPatternsPOC.creacionales.Factory_Method.ejemplo_real.patron.product.impl.MonedaUSA;

public class MonedaFactory {

    public static IMoneda crearMoneda(String pais){
        switch (pais) {
            case "ARGENTINA" : return new MonedaARS();
            case "USA" : return new MonedaUSA();
            default: return null;
        }
    }

}
