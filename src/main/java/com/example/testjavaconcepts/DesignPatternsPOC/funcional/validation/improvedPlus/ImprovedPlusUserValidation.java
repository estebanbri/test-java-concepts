package com.example.testjavaconcepts.DesignPatternsPOC.funcional.validation.improvedPlus;

import com.example.testjavaconcepts.DesignPatternsPOC.funcional.model.User;
import com.example.testjavaconcepts.DesignPatternsPOC.funcional.validation.improved.ImprovedUserValidation;

import java.util.function.Function;
import java.util.function.Predicate;

import static com.example.testjavaconcepts.DesignPatternsPOC.funcional.validation.improvedPlus.ValidationPlusResult.invalid;
import static com.example.testjavaconcepts.DesignPatternsPOC.funcional.validation.improvedPlus.ValidationPlusResult.valid;

public interface ImprovedPlusUserValidation extends Function<User, ValidationPlusResult> {

    static ImprovedPlusUserValidation nameIsNotEmpty () {
        return holds(user -> !user.getName().trim().isEmpty(), "Name is empty.");
    }

    static ImprovedPlusUserValidation emailContainsAtSign() {
        return holds(user -> user.getEmail().contains("@"), "Missing @-sign.");
    }

    static ImprovedPlusUserValidation isAgeValid() {
        return holds(user -> user.getAge() > 18, "Not valid age.");
    }

    static ImprovedPlusUserValidation holds(Predicate<User> p, String message){
        return user -> p.test(user) ? valid() : invalid(message);
    }

    default ImprovedPlusUserValidation and(Function<User, ValidationPlusResult> other) {
        return user -> {
            ValidationPlusResult result = this.apply(user);
            return result.isValid() ? other.apply(user) : result;
        };
    }


}