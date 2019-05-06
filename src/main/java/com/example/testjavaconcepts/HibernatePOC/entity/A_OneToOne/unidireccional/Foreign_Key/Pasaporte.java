package com.example.testjavaconcepts.HibernatePOC.entity.A_OneToOne.unidireccional.Foreign_Key;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Pasaporte {

    @Id
    public Long id;

    @OneToOne(mappedBy = "pasaporte")
    public Cliente cliente;

}

//  +------------+
//  |  Pasaporte |
//  +------------+
//  |     ID     |
//  +------------+
