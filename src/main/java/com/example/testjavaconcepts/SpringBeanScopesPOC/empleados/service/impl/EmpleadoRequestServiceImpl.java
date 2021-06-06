package com.example.testjavaconcepts.SpringBeanScopesPOC.empleados.service.impl;



import com.example.testjavaconcepts.SpringBeanScopesPOC.empleados.component.EmpleadosProvider;
import com.example.testjavaconcepts.SpringBeanScopesPOC.empleados.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@Service("EmpleadoRequestService")
@RequestScope
public class EmpleadoRequestServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadosProvider empleadoProvider;

    private List<String> empleados;

    @Override
    public List<String> getEmpleados(String username) {
        if(empleados == null){
            EmpleadosProvider.requestCount++;
            empleados = empleadoProvider.get(username);
        }
        return empleados;
    }

}
