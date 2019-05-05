package com.example.testjavaconcepts.HibernatePOC.entity.unidirecional.OneToMany;

import javax.persistence.*;

@Entity
public class Email {

    @Id
    private Long id1;

    @ManyToOne
    private Employee employee;

}
