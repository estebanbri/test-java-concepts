package com.example.testjavaconcepts.InmutablePOC;

public final class SimpleInmutable { // agregamos final para que no pueda ser heredada

    private final String str; // agregamos final para que no pueda ser modificada la referencia str

    private final int number; // agregamos final para que no pueda ser modificada la referencia number

    SimpleInmutable(String str, int number) {
        this.str = str;
        this.number = number;
    }

    public String getStr() {
        return str;
    }

    public int getNumber() {
        return number;
    }

    // NO SETTERS : porque no tiene que existir modificaciones del obj


    @Override
    public String toString() {
        return "SimpleInmutable{" +
                "str='" + str + '\'' +
                ", number=" + number +
                '}';
    }
}
