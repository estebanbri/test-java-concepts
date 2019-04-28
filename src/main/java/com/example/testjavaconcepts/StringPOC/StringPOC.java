package com.example.testjavaconcepts.StringPOC;

public class StringPOC {
    public static void main(String[] args) {
        m1();

    }

    private static void m1(){
        String a = "asd";
        String b = "asd";
        if( a==b ){System.out.println("Meaningful equivalentes");}

        if( a=="asd" ){System.out.println("Meaningful equivalentes");}

        if( a instanceof Object){
            System.out.println("Heredo de Object class");
        }
    }

    private static void prueba_indexOf(){
        int index = "asd".indexOf("as");
        if (index == -1)
        {
            System.out.println("SUB-STRING NO ENCONTRADO!...");
        }else{
            System.out.println("SUB-STRING ENCONTRADO!...");
        }
    }
}
