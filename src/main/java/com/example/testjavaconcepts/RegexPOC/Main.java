package com.example.testjavaconcepts.RegexPOC;

// Alternativa 1: Scanner(Source source)    -> Esta manera tambien podrias tomar como input un archivo (file)
    // useDelimiter(String regex)
    // useDelimiter(Pattern pattern)

// Alternativa 2: String
    // split(String regex)

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ScannerPOC();
        StringPOC();
    }

    public static void ScannerPOC(){
        Scanner scanner = new Scanner("Manzana/Pera/Banana");
        scanner.useDelimiter("/");
        while(scanner.hasNext()){
            String token = scanner.next();
            System.out.println(token);
        }
        scanner.close();
    }


    public static void StringPOC(){
        String input = ("Kiwi/Naranja/Anana");
        String[] tokens = input.split("/");
        for(String token: tokens){
            System.out.println(token);
        }
        String json = "{\n" +
                "  \"marca\": \"fiat\",\n" +
                "  \"cantidad_ruedas\" : 3,\n" +
                "  \"nombre\": \"json\"\n" +
                "}";
    }
}
