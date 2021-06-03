package com.example.testjavaconcepts.SpringBeanScopesPOC.controller;

import com.example.testjavaconcepts.SpringBeanScopesPOC.service.request.FechaRequestService;
import com.example.testjavaconcepts.SpringBeanScopesPOC.service.session.FechaSessionService;
import com.example.testjavaconcepts.SpringBeanScopesPOC.service.singleton.FechaSingletonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FechaController {


    @Autowired
    private FechaSingletonService fechaSingletonService;

    @Autowired
    private FechaRequestService fechaRequestService;

    @Autowired
    private FechaSessionService fechaSessionService;

    @RequestMapping(value = "/fecha", method = RequestMethod.GET)
    public String getFecha() {
        String result = "";
        result = result.concat("Singleton:").concat(fechaSingletonService.getHora().toString()).concat("<br>");
        result = result.concat("Request:").concat(fechaRequestService.getHora().toString()).concat("<br>");
        result = result.concat("Session:").concat(fechaSessionService.getHora().toString()).concat("\n");
        return result;
    }

}
