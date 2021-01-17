package com.example.testjavaconcepts.DesignPatternsPOC.creacionales.Factory_Method.ejemplo_real.patron.product.impl;

import com.example.testjavaconcepts.DesignPatternsPOC.creacionales.Factory_Method.ejemplo_real.patron.product.IMoneda;

public class MonedaUSA implements IMoneda {
    @Override
    public String getDescription() {
        return "USD";
    }
}
