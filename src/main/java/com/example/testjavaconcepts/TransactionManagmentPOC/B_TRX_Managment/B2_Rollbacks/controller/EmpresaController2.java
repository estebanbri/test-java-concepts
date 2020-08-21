package com.example.testjavaconcepts.TransactionManagmentPOC.B_TRX_Managment.B2_Rollbacks.controller;

import com.example.testjavaconcepts.TransactionManagmentPOC.B_TRX_Managment.B2_Rollbacks.service.EmpresaService2;
import com.example.testjavaconcepts.TransactionManagmentPOC.entity.Empleado;
import com.example.testjavaconcepts.TransactionManagmentPOC.entity.ObraSocial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpresaController2 {

    @Autowired
    private EmpresaService2 empresaService;

    @PostMapping(value = "/join2")
    public void joinEmpresa(){

         Empleado empleado = new Empleado();
         empleado.setEmpId(1L);
         empleado.setEmpName("emp1");

         ObraSocial obraSocial = new ObraSocial();
         obraSocial.setEmpId(1L);
         obraSocial.setHealthInsuranceSchemeName("premium");
         obraSocial.setCoverageAmount(20000);

         empresaService.joinEmpresa(empleado, obraSocial);
     }
}
