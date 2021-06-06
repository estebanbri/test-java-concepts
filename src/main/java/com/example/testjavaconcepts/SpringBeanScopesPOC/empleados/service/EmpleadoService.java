package com.example.testjavaconcepts.SpringBeanScopesPOC.empleados.service;

import java.util.List;

public interface EmpleadoService {
    List<String> getEmpleados(String loggedUserMsg);
}
