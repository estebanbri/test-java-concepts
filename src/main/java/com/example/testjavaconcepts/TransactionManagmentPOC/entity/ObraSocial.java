package com.example.testjavaconcepts.TransactionManagmentPOC.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ObraSocial {

    @Id
    private Long empId;
    private String healthInsuranceSchemeName;
    private int coverageAmount;

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getHealthInsuranceSchemeName() {
        return healthInsuranceSchemeName;
    }

    public void setHealthInsuranceSchemeName(String healthInsuranceSchemeName) {
        this.healthInsuranceSchemeName = healthInsuranceSchemeName;
    }

    public int getCoverageAmount() {
        return coverageAmount;
    }

    public void setCoverageAmount(int coverageAmount) {
        this.coverageAmount = coverageAmount;
    }
}
