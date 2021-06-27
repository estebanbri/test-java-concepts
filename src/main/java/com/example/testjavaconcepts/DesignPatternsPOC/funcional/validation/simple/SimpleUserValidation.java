package com.example.testjavaconcepts.DesignPatternsPOC.funcional.validation.simple;

import com.example.testjavaconcepts.DesignPatternsPOC.funcional.model.User;

import java.util.function.Function;

/**
 *  Validacion (funcion) que retorna un boolean
 */
public interface SimpleUserValidation extends Function<User, Boolean> {

    static SimpleUserValidation nameIsNotEmpty () {
        return user -> !user.getName().trim().isEmpty();
    }

    static SimpleUserValidation emailContainsAtSign() {
        return user -> user.getEmail().contains("@");
    }

    static SimpleUserValidation isAgeValid() {
        return user -> user.getAge() > 18;
    }

    default SimpleUserValidation and(Function<User, Boolean> other) {
        return user -> this.apply(user) && other.apply(user);
    }


}
