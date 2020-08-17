package com.example.testjavaconcepts.TransactionManagmentPOC.A_Sin_TRX_Managment.repository;

import com.example.testjavaconcepts.TransactionManagmentPOC.entity.ObraSocial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObraSocialRepository1 extends JpaRepository<ObraSocial, Long> {

}
