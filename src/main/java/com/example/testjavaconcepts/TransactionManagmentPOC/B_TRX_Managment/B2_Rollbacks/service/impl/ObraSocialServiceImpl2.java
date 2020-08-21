package com.example.testjavaconcepts.TransactionManagmentPOC.B_TRX_Managment.B2_Rollbacks.service.impl;

import com.example.testjavaconcepts.TransactionManagmentPOC.B_TRX_Managment.B2_Rollbacks.repository.ObraSocialRepository2;
import com.example.testjavaconcepts.TransactionManagmentPOC.B_TRX_Managment.B2_Rollbacks.service.ObraSocialService2;
import com.example.testjavaconcepts.TransactionManagmentPOC.entity.ObraSocial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObraSocialServiceImpl2 implements ObraSocialService2 {

    @Autowired
    private ObraSocialRepository2 repository;

    @Override
    public void registrarObraSocial(ObraSocial obraSocial) {
        repository.save(obraSocial);
    }
}
