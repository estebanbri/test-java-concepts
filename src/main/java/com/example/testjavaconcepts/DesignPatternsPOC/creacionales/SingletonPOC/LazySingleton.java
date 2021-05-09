package com.example.testjavaconcepts.DesignPatternsPOC.creacionales.SingletonPOC;

public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton(){}

    public static LazySingleton getInstance(){
        // check if instance already exist
        if(instance == null){
            instance = new LazySingleton();
        }
       return instance;
    }

}
