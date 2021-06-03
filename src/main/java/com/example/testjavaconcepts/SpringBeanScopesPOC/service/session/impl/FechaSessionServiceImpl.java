package com.example.testjavaconcepts.SpringBeanScopesPOC.service.session.impl;

import com.example.testjavaconcepts.SpringBeanScopesPOC.service.session.FechaSessionService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.time.LocalDateTime;

@Service
@SessionScope
public class FechaSessionServiceImpl implements FechaSessionService {
    private LocalDateTime fecha = LocalDateTime.now();

    @Override
    public LocalDateTime getHora() {
        return fecha;
    }
}
