package com.example.testjavaconcepts.TransactionManagmentPOC.A_Sin_TRX_Managment.service.impl;

import com.example.testjavaconcepts.TransactionManagmentPOC.A_Sin_TRX_Managment.service.EmpleadoService1;
import com.example.testjavaconcepts.TransactionManagmentPOC.A_Sin_TRX_Managment.service.EmpresaService1;
import com.example.testjavaconcepts.TransactionManagmentPOC.A_Sin_TRX_Managment.service.ObraSocialService1;
import com.example.testjavaconcepts.TransactionManagmentPOC.entity.Empleado;
import com.example.testjavaconcepts.TransactionManagmentPOC.entity.ObraSocial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaServiceImpl1 implements EmpresaService1 {

    @Autowired
    private EmpleadoService1 empleadoService;

    @Autowired
    private ObraSocialService1 obraSocialService;

    @Override
    public void joinEmpresa(Empleado empleado, ObraSocial obraSocial) {
        empleadoService.insertEmpleado(empleado);
        if(empleado.getEmpName().equals("emp1")){ // simulamos para lanzar una excepcion
            throw new RuntimeException();
        }
        obraSocialService.registrarObraSocial(obraSocial);
    }

    // Resultado: Inconsistencia de datos (Por la excepcion lanzada justo antes de almacenar los datos de la obra social, hizo que te quede inconsistencia en la db con datos del empleado insertados pero de la obra social no)
    // Solucion: Usar @Transactional (TRX Managment de Spring). Es decir realizar ambas operaciones de insercion a las tablas de manera atomica, o se hacen ambas o ninguna.

    //+-------+----------+
    //|EMP_ID | EMP_NAME |
    //+-------+----------+
    //|   1	  |   emp1   |
    //+-------+----------+

    // +--------+-----------------+------------------------------+
    // | EMP_ID | COVERAGE_AMOUNT | HEALTH_INSURANCE_SCHEME_NAME |
    // +--------+-----------------+------------------------------+
    // |        |                 |                              |
    // +--------+-----------------+------------------------------+
}
