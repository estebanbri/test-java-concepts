package com.example.testjavaconcepts.ApplicationPropertiesPOC;

import org.springframework.beans.factory.annotation.Value;

public class ApplicationPropertiesPOC {

    @Value("${url.esteban}")
    static String s;

    public static void main(String[] args) {
        System.out.print(s);
    }

}
