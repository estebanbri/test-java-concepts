package com.example.testjavaconcepts.ExceptionPOC;

/**
 *  Util cuando por ejemplo tu metodo necesita recibir como input un numero entero positivo
 */
public class IlegalArgumentExceptionPOC {

    public static void main(String[] args) {

        int entero_positivo = 2;
        int entero_negativo = -1;
        int i = IlegalArgumentExepcionPOC(entero_negativo);
        System.out.println(i);

    }

    private static int IlegalArgumentExepcionPOC(int i){
        if(i < 0){ // check entero positivo
            throw new IllegalArgumentException("El entero debe ser mayor que cero !!");
        }
        return i;
    }
}
