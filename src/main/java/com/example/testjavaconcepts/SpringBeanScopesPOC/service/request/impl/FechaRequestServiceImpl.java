package com.example.testjavaconcepts.SpringBeanScopesPOC.service.request.impl;

import com.example.testjavaconcepts.SpringBeanScopesPOC.service.request.FechaRequestService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.time.LocalDateTime;

@Service
@RequestScope
public class FechaRequestServiceImpl implements FechaRequestService {
    private LocalDateTime fecha = LocalDateTime.now();

    @Override
    public LocalDateTime getHora() {
        return fecha;
    }
}
