package com.example.testjavaconcepts.DesignPatternsPOC.creacionales.Factory_Method.ejemplo_real.patron.product.impl;

import com.example.testjavaconcepts.DesignPatternsPOC.creacionales.Factory_Method.ejemplo_real.patron.product.IMoneda;

public class MonedaARS implements IMoneda {
    @Override
    public String getDescription() {
        return "ARS";
    }
}
