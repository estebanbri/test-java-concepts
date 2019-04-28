package com.example.testjavaconcepts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
public class PersonaController {

    @Autowired
    PersonaService personaService;

    // Cuando tu metodo puede o no devolver un body usas -> ?
    @GetMapping("/personas1")
    public ResponseEntity<?> getPersonas1(@RequestHeader Map<String, String> headers) {

        // Get RESQUEST HEADERS
        final String SOY_EL_HEADER_DEL_REQUEST = headers.get("soy_el_header_del_request");

        List<Persona> responseBody = Collections.emptyList();// personaService.getPersonas();

        if (responseBody.isEmpty()) {
            return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        }

        // Set RESPONSE HEADERS
        HttpHeaders header = new HttpHeaders();
        header.add("MI_HEADER", "asd");

        return new ResponseEntity<>(responseBody, header, HttpStatus.OK);
    }

    // Cuando tu metodo devuelve siempre un body usas -> List<Persona>
    @GetMapping("/personas2")
    public ResponseEntity<List<Persona>> getPersonas2(){

        List<Persona> responseBody = Collections.emptyList();// personaService.getPersonas();

        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    // Cuando tu metodo nunca devuelve un body usas -> Void
    @GetMapping("/personas3")
    public ResponseEntity<Void> getPersonas3(@RequestHeader Map<String, String> headers){

        return new ResponseEntity<>(HttpStatus.OK);

    }

}
