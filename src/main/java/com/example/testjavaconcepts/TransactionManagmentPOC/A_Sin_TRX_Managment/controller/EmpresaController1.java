package com.example.testjavaconcepts.TransactionManagmentPOC.A_Sin_TRX_Managment.controller;

import com.example.testjavaconcepts.TransactionManagmentPOC.A_Sin_TRX_Managment.service.EmpresaService1;
import com.example.testjavaconcepts.TransactionManagmentPOC.entity.Empleado;
import com.example.testjavaconcepts.TransactionManagmentPOC.entity.ObraSocial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpresaController1 {

    @Autowired
    private EmpresaService1 empresaService;

    @PostMapping(value = "/join1")
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
