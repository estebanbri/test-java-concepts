package com.example.testjavaconcepts.DesignPatternsPOC.funcional;

import com.example.testjavaconcepts.DesignPatternsPOC.funcional.model.User;
import com.example.testjavaconcepts.DesignPatternsPOC.funcional.validation.improvedPlus.ImprovedPlusUserValidation;
import com.example.testjavaconcepts.DesignPatternsPOC.funcional.validation.improved.ImprovedUserValidation.*;
import com.example.testjavaconcepts.DesignPatternsPOC.funcional.validation.improvedPlus.ValidationPlusResult;
import com.example.testjavaconcepts.DesignPatternsPOC.funcional.validation.simple.SimpleUserValidation;
import com.example.testjavaconcepts.DesignPatternsPOC.funcional.validation.improved.ImprovedUserValidation;

public class Main {
    public static void main(String[] args) {

        User user = new User("Esteban", 18, "a@gmail.com");

        // SIMPLE
        Boolean result1 = SimpleUserValidation.nameIsNotEmpty()
                .and(SimpleUserValidation.emailContainsAtSign ())
                .and(SimpleUserValidation.isAgeValid())
                .apply(user);

        System.out.println(result1);

        // IMPROVED
        ValidationResult result2 = ImprovedUserValidation.nameIsNotEmpty()
                .and(ImprovedUserValidation.emailContainsAtSign ())
                .and(ImprovedUserValidation.isAgeValid())
                .apply(user);

        System.out.println(result2);

        // IMPROVED++
        ValidationPlusResult result3 = ImprovedPlusUserValidation.nameIsNotEmpty()
                .and(ImprovedPlusUserValidation.emailContainsAtSign ())
                .and(ImprovedPlusUserValidation.isAgeValid())
                .apply(user);

        System.out.println(result3);


    }



}
