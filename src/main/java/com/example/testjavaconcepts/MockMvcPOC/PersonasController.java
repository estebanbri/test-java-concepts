package com.example.testjavaconcepts.MockMvcPOC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonasController {

    @Autowired
    PersonasService service;

    @GetMapping("/personas")
    public List<Persona> getPersonas(){
        List<Persona> persona = service.getPersonas();
        return persona;
    }

    @GetMapping("/personas/saludo")
    public String getPersonasSaludo(){
        return "Saludo desde el Controller";
    }

}
