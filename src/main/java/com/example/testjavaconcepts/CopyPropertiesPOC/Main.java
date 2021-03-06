package com.example.testjavaconcepts.CopyPropertiesPOC;

import org.springframework.beans.BeanUtils;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // Source
        Fuente fuente = new Fuente();
        fuente.setId(1L);
        fuente.setNombre("Jose");
        fuente.setApellido("Perez");
        fuente.setTelefonos(Arrays.asList("154118808","156027569"));

        // Target
        Destino destino = new Destino();

        // En teoria mira los getters y setters eso es lo que tiene que matchear, es decir no mira la sintaxis de las variables de instancias como vos creias
        BeanUtils.copyProperties(fuente, destino);

        System.out.print(destino);
    }
}
