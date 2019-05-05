package com.example.testjavaconcepts.HibernatePOC.entity.bidireccional.OneToMany_ManyToOne;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity  // inverse side (non-owning side)
public class Employee1 {

    @Id
    private Long id2;

    @OneToMany(mappedBy = "employee")
    private List<Email1> emails;

}

