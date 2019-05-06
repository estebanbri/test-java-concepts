package com.example.testjavaconcepts.HibernatePOC.entity.A_OneToOne.unidireccional.Shared_Primary_Key;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Corazon {

    @Id
    public Long id;

}

//  +------------+
//  |   Corazon  |
//  +------------+
//  |     ID     |
//  +------------+
