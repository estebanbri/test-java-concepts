package com.example.testjavaconcepts.DesignPatternsPOC.funcional.validation.improved;

import com.example.testjavaconcepts.DesignPatternsPOC.funcional.model.User;
import static com.example.testjavaconcepts.DesignPatternsPOC.funcional.validation.improved.ImprovedUserValidation.*;

import java.util.function.Function;

/**
 *  Validacion (funcion) que retorna un enum
 */
public interface ImprovedUserValidation extends Function<User, ValidationResult> {

    static ImprovedUserValidation nameIsNotEmpty () {
        return user -> !user.getName().trim().isEmpty() ?
                ValidationResult.VALID : ValidationResult.NAME_INVALID;
    }

    static ImprovedUserValidation emailContainsAtSign() {
        return user -> user.getEmail().contains("@") ?
                ValidationResult.VALID : ValidationResult.EMAIL_INVALID;
    }

    static ImprovedUserValidation isAgeValid() {
        return user -> user.getAge() > 18 ?
                ValidationResult.VALID : ValidationResult.AGE_INVALID;
    }

    default ImprovedUserValidation and(Function<User, ValidationResult> other) {
        return user -> {
            ValidationResult result = this.apply(user);
            return result.equals(ValidationResult.VALID) ? other.apply(user) : result;
        };
    }

    enum ValidationResult {
        VALID,
        NAME_INVALID,
        AGE_INVALID,
        EMAIL_INVALID
    }

}
