package com.example.testjavaconcepts.StringPOC;

import java.io.IOException;

public class StringPOC {
    public static void main(String[] args) {
        charAtPOC();
    }

    private static void equalityPOC(){
        String a = "asd";
        String b = "asd";
        if( a == b ){System.out.println("Meaningful equivalentes");}

        if( a == "asd" ){System.out.println("Meaningful equivalentes");}

        if( a instanceof Object){
            System.out.println("Heredo de Object class");
        }
    }

    private static void indexOfPOC(){
        int index = "asd".indexOf("as");
        if (index == -1)
        {
            System.out.println("SUB-STRING NO ENCONTRADO!...");
        }else{
            System.out.println("SUB-STRING ENCONTRADO!...");
        }
    }

    // int -> String
    private static void valueOfPOC(){
        String s = String.valueOf(13);
        System.out.println(s);     // "13"
    }

    private static void substringPOC(){
        String s = "ASD";
        String s2 = s.substring(1);
        System.out.println(s2);    // "SD"
    }

    private static void toUpperCasePOC(){
        String s = "asd";
        String s2 = s.toUpperCase();
        System.out.println(s2);   // "ASD"
    }

    private static void toLowerCasePOC(){
        String s = "ASD";
        String s2 = s.toLowerCase();
        System.out.println(s2);   // "asd"
    }

    private static void trimPOC(){
        String s = "   esteban    ";
        String s2 = s.trim();
        System.out.println(s2);   // "esteban"
    }

    private static void startsWithPOC(){
        String s = "   Esteban    ";
        boolean b = s.startsWith("E");  // true
        if(b){
            System.out.println("Comienza con letra E");
        }else{
            System.out.println("No comienza con letra E");
        }
    }

    private static void concatPOC(){
        String s = "Esteban";
        String s2 = s.concat("Briceño");
        System.out.println(s2);   // EstebanBriceño
    }

    private static void charAtPOC(){
        String s = "Esteban";
        char c = s.charAt(1);
        System.out.println(c);   // s

    }
}
