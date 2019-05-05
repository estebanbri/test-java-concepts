package com.example.testjavaconcepts.HibernatePOC.entity.bidireccional.OneToMany_ManyToOne;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity // owning side
public class Email1 {

    @Id
    private Long id1;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee1 employee;

}
