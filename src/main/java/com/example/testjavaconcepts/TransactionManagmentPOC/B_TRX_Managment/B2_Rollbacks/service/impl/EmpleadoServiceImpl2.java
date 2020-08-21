package com.example.testjavaconcepts.TransactionManagmentPOC.B_TRX_Managment.B2_Rollbacks.service.impl;

import com.example.testjavaconcepts.TransactionManagmentPOC.B_TRX_Managment.B2_Rollbacks.repository.EmpleadoRepository2;
import com.example.testjavaconcepts.TransactionManagmentPOC.B_TRX_Managment.B2_Rollbacks.service.EmpleadoService2;
import com.example.testjavaconcepts.TransactionManagmentPOC.entity.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoServiceImpl2 implements EmpleadoService2 {

    @Autowired
    private EmpleadoRepository2 repository;

    @Override
    public void insertEmpleado(Empleado empleado) {
        repository.save(empleado);
    }

}
