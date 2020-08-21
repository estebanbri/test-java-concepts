package com.example.testjavaconcepts.TransactionManagmentPOC.B_TRX_Managment.B2_Rollbacks.service.impl;

import com.example.testjavaconcepts.TransactionManagmentPOC.B_TRX_Managment.B2_Rollbacks.service.EmpleadoService2;
import com.example.testjavaconcepts.TransactionManagmentPOC.B_TRX_Managment.B2_Rollbacks.service.EmpresaService2;
import com.example.testjavaconcepts.TransactionManagmentPOC.B_TRX_Managment.B2_Rollbacks.service.ObraSocialService2;
import com.example.testjavaconcepts.TransactionManagmentPOC.entity.Empleado;
import com.example.testjavaconcepts.TransactionManagmentPOC.entity.ObraSocial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpresaServiceImpl2 implements EmpresaService2 {

    @Autowired
    private EmpleadoService2 empleadoService;

    @Autowired
    private ObraSocialService2 obraSocialService;

    @Override
    @Transactional // tratamos joinEmpresa como una operacion atomica
    public void joinEmpresa(Empleado empleado, ObraSocial obraSocial) {
        empleadoService.insertEmpleado(empleado);
        if(empleado.getEmpName().equals("emp1")){ // simulamos para lanzar una excepcion
            throw new RuntimeException();
        }
        obraSocialService.registrarObraSocial(obraSocial);
    }


    // Resultado: DB Consistente, al tratar ambas operaciones de insercion a las tablas como una unica operacion atomica, si una falla de hace el rollback de las inserciones previas, si no hay falla se comitea.

    //+-------+----------+
    //|EMP_ID | EMP_NAME |
    //+-------+----------+
    //|  	  |          |
    //+-------+----------+

    // +--------+-----------------+------------------------------+
    // | EMP_ID | COVERAGE_AMOUNT | HEALTH_INSURANCE_SCHEME_NAME |
    // +--------+-----------------+------------------------------+
    // |        |                 |                              |
    // +--------+-----------------+------------------------------+
}
