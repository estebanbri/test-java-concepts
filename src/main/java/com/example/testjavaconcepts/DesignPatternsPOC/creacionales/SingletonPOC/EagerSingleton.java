package com.example.testjavaconcepts.DesignPatternsPOC.creacionales.SingletonPOC;

public class EagerSingleton {

    private static EagerSingleton instance = new EagerSingleton();

    private EagerSingleton(){}

    public static EagerSingleton getInstance(){
        return instance;
    }

}
