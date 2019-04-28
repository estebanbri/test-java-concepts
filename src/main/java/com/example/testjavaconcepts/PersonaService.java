package com.example.testjavaconcepts;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Arrays;

@Service
public class PersonaService {

    public List<Persona> getPersonas(){
        return Arrays.asList(
                new Persona(101, "Esteban"),
                new Persona(102, "Jose")
                );
    }
}
