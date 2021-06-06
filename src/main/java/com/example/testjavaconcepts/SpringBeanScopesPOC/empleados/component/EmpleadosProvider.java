package com.example.testjavaconcepts.SpringBeanScopesPOC.empleados.component;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class EmpleadosProvider {

    private Map<String, List<String>> empleadosMap = new HashMap<>();

    public static int singletonCount;
    public static int requestCount;
    public static int sessionCount;

    @PostConstruct
    private void init(){
        empleadosMap.put("pepe", Arrays.asList("Patricio","Pancracio"));
        empleadosMap.put("jose", Arrays.asList("Josualdo","Jacinto"));
    }

    /**
     *  Simula ser una llamada a algun proveeder o endpoint que es costo de llamar
     *  continuamente por eso es preferible almacenar el response en memoria en un objeto dentro de nuestra app.
     * @param username
     * @return
     */
    public List<String> get(String username){
        return empleadosMap.getOrDefault(username, Collections.singletonList("SIN_EMPLEADOS"));
    }

}
