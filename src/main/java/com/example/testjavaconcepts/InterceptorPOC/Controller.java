package com.example.testjavaconcepts.InterceptorPOC;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class Controller {

    @GetMapping("/saludo")
    public String getSaludo(){
        return "Hola mundoo";
    }

}
