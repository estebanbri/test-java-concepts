package com.example.testjavaconcepts.TransactionManagmentPOC.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Empleado {

    @Id
    private Long empId;
    private String empName;

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }
}
