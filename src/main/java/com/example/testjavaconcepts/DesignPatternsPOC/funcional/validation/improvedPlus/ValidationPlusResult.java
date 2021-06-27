package com.example.testjavaconcepts.DesignPatternsPOC.funcional.validation.improvedPlus;

import java.util.Optional;

public interface ValidationPlusResult {

    static ValidationPlusResult valid(){
        return ValidationSupport.valid();
    }

    static ValidationPlusResult invalid(String reason){
        return new Invalid(reason);
    }

    boolean isValid();

    Optional<String> getReason();

    class Invalid implements ValidationPlusResult {

        private final String reason;

        Invalid(String reason){
            this.reason = reason;
        }

        public boolean isValid(){
            return false;
        }

        public Optional<String> getReason(){
            return Optional.of(reason);
        }

        @Override
        public String toString() {
            return "Invalid{" +
                    "reason='" + reason + '\'' +
                    '}';
        }
    }

    class ValidationSupport {
        private static final ValidationPlusResult valid = new ValidationPlusResult(){
            public boolean isValid(){ return true; }
            public Optional<String> getReason(){ return Optional.empty(); }
        };

        static ValidationPlusResult valid(){
            // since all valid results are indistinguishable,
            // the same instance can be reused to reduce garbage
            return valid;
        }
    }
}
