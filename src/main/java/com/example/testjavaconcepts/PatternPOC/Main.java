package com.example.testjavaconcepts.PatternPOC;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  -----------------------------------
 *  String: split() vs Pattern: split()
 *  -----------------------------------
 *  El problema de usar el los metodos split(regex) y matches(regex) es que cada vez que les hacer call you recompile the pattern, which cost some resources.
 *  It is better to compile your pattern once usando la el metodo compile() de la clase Pattern, then try to match it against all the Strings you want.
 *  Nota:
 *   String split() internamente calls Pattern.split(regex,  str).
 *   String matches() internamente calls Pattern.matches(regex,  str).
 */

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

    // Pattern class: String[] split(String input) este metodo es el que se ejecuta behind the scenes cuando usas el metodo split() de la clase String
    public static void PatternSplitPOC(){
        String input = "esteban,bricenoSOY_EL_SEPARADORandres,sati";

        Pattern pattern = Pattern.compile("SOY_EL_SEPARADOR");

        String[] tokens = pattern.split(input);

        for (String token : tokens){
            System.out.println(token);
        }


    }
}
