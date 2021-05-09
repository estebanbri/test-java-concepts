package com.example.testjavaconcepts.DesignPatternsPOC.creacionales.Builder;

public class Person {

    private final String lastName;
    private final String firstName;

    //
    // 1 - Private Person constructor
    //
    private Person(Builder builder) {
        this.lastName = builder.lastName;
        this.firstName = builder.firstName;
    }

    public static class Builder {

        private String lastName;
        private String firstName;

        //
        // 2 - Setters del Builder
        //
        public Builder lastName(String newLastName) {  // = "setter del builder"
            this.lastName = newLastName;
            return this; // retorno Builder
        }

        public Builder firstName(String newFirstName) {  // = "setter del builder"
            this.firstName = newFirstName;
            return this; // retorno Builder
        }

        //
        // 3 - Metodo que retorna un objeto construido de Person
        //
        public Person build() {
            return new Person(this);             // esta linea debajo seria tu creacion convencional lo que vos hacias en el main para creear un objeto Persona pero la diferencia es que le pasas la referencia al Builder para poder absorverle los valores.
        }
    }
}
