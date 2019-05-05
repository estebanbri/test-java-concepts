package com.example.testjavaconcepts.HibernatePOC.entity.unidirecional.OneToMany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Employee {

    @Id
    private Long id2;

    @OneToMany
    @JoinColumn(name= "EMAIL_PK")
    private List<Email> emails;

}

