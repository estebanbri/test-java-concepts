package com.example.testjavaconcepts.HibernatePOC.entity.A_OneToOne.unidireccional.Foreign_Key;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Cliente {

    @Id
    public Long id;

    @OneToOne
    @JoinColumn(name="pasaporte_fk")
    public Pasaporte pasaporte;

}

//  +-----------------------+
//  |         Cliente       |
//  +--------+--------------+
//  |   ID   | PASAPORTE_FK |
//  +--------+--------------+
