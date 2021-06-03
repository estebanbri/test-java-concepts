package com.example.testjavaconcepts.SpringBeanScopesPOC.service.singleton.impl;

import com.example.testjavaconcepts.SpringBeanScopesPOC.service.singleton.FechaSingletonService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FechaSingletonServiceImpl implements FechaSingletonService {

    private LocalDateTime fecha = LocalDateTime.now();

    @Override
    public LocalDateTime getHora() {
        return fecha;
    }
}
