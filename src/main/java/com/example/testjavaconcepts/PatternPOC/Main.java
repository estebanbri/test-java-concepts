package com.example.testjavaconcepts.PatternPOC;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        ScannerPatternPOC();
        PatternMatcherPOC();
    }

    // Scanner va separar tu input string segun el patron_regex que le definas en compile(), pensalo como tu nuevo separador
    public static void ScannerPatternPOC(){

        String input = "esteban,bricenoSOY_EL_SEPARADORandres,sati";

        Pattern pattern = Pattern.compile("SOY_EL_SEPARADOR");

        Scanner scanner = new Scanner(input);
        scanner.useDelimiter(pattern);

        while(scanner.hasNext()){
            String token = scanner.next();
            System.out.println(token);
        }
    }

    // Metodo que reemplaza "SOY_EL_SEPARADOR" por "|"
    public static void PatternMatcherPOC(){
        String input = "esteban,bricenoSOY_EL_SEPARADORandres,sati";

        Pattern pattern = Pattern.compile("SOY_EL_SEPARADOR");

        Matcher matcher = pattern.matcher(input);

        String resultado = matcher.replaceAll("|");

        System.out.println(resultado);
    }
}
