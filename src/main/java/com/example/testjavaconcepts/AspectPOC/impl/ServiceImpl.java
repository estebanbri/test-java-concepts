package com.example.testjavaconcepts.AspectPOC.impl;

import com.example.testjavaconcepts.AspectPOC.Service;
import com.example.testjavaconcepts.AspectPOC.annotation.Loggeable;
import org.springframework.stereotype.Component;

@Component
public class ServiceImpl implements Service {

    @Loggeable(valor = "bb")
    public Object m1(String saludo) {
        System.out.println("Ejecutando m1");
        return "aa";
    }

}
