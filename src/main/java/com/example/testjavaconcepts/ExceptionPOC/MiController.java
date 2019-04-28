package com.example.testjavaconcepts.ExceptionPOC;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class MiController {

    @GetMapping("/exception-poc")
    public ResponseEntity<?> get (@RequestParam String flag){

        if(flag.equals("true")){
            throw new MiException(new ApiError("Hubo un problema!","/v1/exception-poc?flag=true"));
        }
        String llegue = "llegue";
        return new ResponseEntity<>(llegue, HttpStatus.OK);
    }


}


