package com.example.testjavaconcepts.MockMvcPOC;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PersonasService {

    public List<Persona> getPersonas() {
        List<Persona> personas = Arrays.asList(
                new Persona("Jose",15),
                new Persona("Pedro",20));
        return personas ;
    }
}
