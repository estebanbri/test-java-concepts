package com.example.testjavaconcepts.TransactionManagmentPOC.A_Sin_TRX_Managment.service.impl;

import com.example.testjavaconcepts.TransactionManagmentPOC.A_Sin_TRX_Managment.repository.ObraSocialRepository1;
import com.example.testjavaconcepts.TransactionManagmentPOC.A_Sin_TRX_Managment.service.ObraSocialService1;
import com.example.testjavaconcepts.TransactionManagmentPOC.entity.ObraSocial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObraSocialServiceImpl1 implements ObraSocialService1 {

    @Autowired
    private ObraSocialRepository1 repository;

    @Override
    public void registrarObraSocial(ObraSocial obraSocial) {
        repository.save(obraSocial);
    }
}
