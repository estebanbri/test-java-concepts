package com.example.testjavaconcepts.ExceptionPOC;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerGeneric extends ResponseEntityExceptionHandler {

    @ExceptionHandler({MiException.class})
    public ResponseEntity<ApiError> ex(MiException miException){

        // obtengo los datos del obj MiException
        String mensaje = miException.getApiError().getMensaje();
        String mensajeAlDesarrollador = miException.getApiError().getMensajeAlDesarrollador();

        // preparo el obj ApiError para retornarle al usuario
        ApiError apiError = new ApiError();

        apiError.setMensajeAlDesarrollador(mensajeAlDesarrollador);
        apiError.setMensaje(mensaje);

        return new ResponseEntity<>(apiError, HttpStatus.OK);
    }
}
