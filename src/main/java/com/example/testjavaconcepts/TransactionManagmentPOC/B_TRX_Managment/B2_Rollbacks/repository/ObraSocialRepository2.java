package com.example.testjavaconcepts.TransactionManagmentPOC.B_TRX_Managment.B2_Rollbacks.repository;

import com.example.testjavaconcepts.TransactionManagmentPOC.entity.ObraSocial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObraSocialRepository2 extends JpaRepository<ObraSocial, Long> {

}
