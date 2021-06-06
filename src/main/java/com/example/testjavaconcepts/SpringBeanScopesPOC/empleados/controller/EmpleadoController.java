package com.example.testjavaconcepts.SpringBeanScopesPOC.empleados.controller;


import com.example.testjavaconcepts.SpringBeanScopesPOC.empleados.component.EmpleadosProvider;
import com.example.testjavaconcepts.SpringBeanScopesPOC.empleados.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmpleadoController {


    @Autowired
    @Qualifier("EmpleadoSingletonService")
    private EmpleadoService empleadoSingletonService;

    @Autowired
    @Qualifier("EmpleadoRequestService")
    private EmpleadoService empleadoRequestService;

    @Autowired
    @Qualifier("EmpleadoSessionService")
    private EmpleadoService empleadoSessionService;
    
    @GetMapping("/manager/{name}/empleados")
    public ResponseEntity<String> getEmpleados(@PathVariable("name") String name){
        return new ResponseEntity(this.getHtml(name), HttpStatus.OK);
    }


    private String getHtml(String name){
        return "<h1> Empleados de: " +  name + "</h1><br>"+
                "<ul>"+
                    "<li>" + "Singleton scope bean: " + "<strong>" + empleadoSingletonService.getEmpleados(name) + "</strong>" +
                        "("+ " Cantidad de llamadas a provider = " + "<strong>" + EmpleadosProvider.singletonCount + "</strong>" + ")"+  "</li>" +
                    "<li>" + "Request scope bean: " + "<strong>" + empleadoRequestService.getEmpleados(name) + "</strong>" +
                        "("+ " Cantidad de llamadas a provider = " + "<strong>" + EmpleadosProvider.requestCount + "</strong>" + ")"+  "</li>" +
                    "<li>" + "Session scope bean: " + "<strong>" + empleadoSessionService.getEmpleados(name) + "</strong>" +
                        "("+ " Cantidad de llamadas a provider = " + "<strong>" + EmpleadosProvider.sessionCount + "</strong>" + ")"+  "</li>"
             + "</ul>";
    }
    
}
