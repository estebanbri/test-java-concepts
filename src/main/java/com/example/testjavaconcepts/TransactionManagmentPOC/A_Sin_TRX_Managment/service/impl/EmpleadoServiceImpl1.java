package com.example.testjavaconcepts.TransactionManagmentPOC.A_Sin_TRX_Managment.service.impl;

import com.example.testjavaconcepts.TransactionManagmentPOC.A_Sin_TRX_Managment.repository.EmpleadoRepository1;
import com.example.testjavaconcepts.TransactionManagmentPOC.A_Sin_TRX_Managment.service.EmpleadoService1;
import com.example.testjavaconcepts.TransactionManagmentPOC.entity.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoServiceImpl1 implements EmpleadoService1 {

    @Autowired
    private EmpleadoRepository1 repository;

    @Override
    public void insertEmpleado(Empleado empleado) {
        repository.save(empleado);
    }

}
