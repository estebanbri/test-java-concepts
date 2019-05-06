package com.example.testjavaconcepts.HibernatePOC.entity.A_OneToOne.unidireccional.Shared_Primary_Key;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Cuerpo {

    @Id
    public Long id;

    @OneToOne
    @PrimaryKeyJoinColumn
    public Corazon corazon;

}

//  +------------+
//  |   Cuerpo   |
//  +------------+
//  |     ID     |
//  +------------+
