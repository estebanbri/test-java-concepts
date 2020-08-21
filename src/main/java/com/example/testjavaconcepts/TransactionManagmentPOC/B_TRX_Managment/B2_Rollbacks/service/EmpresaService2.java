package com.example.testjavaconcepts.TransactionManagmentPOC.B_TRX_Managment.B2_Rollbacks.service;

import com.example.testjavaconcepts.TransactionManagmentPOC.entity.Empleado;
import com.example.testjavaconcepts.TransactionManagmentPOC.entity.ObraSocial;

public interface EmpresaService2 {
    void joinEmpresa(Empleado empleado, ObraSocial obraSocial);
}
