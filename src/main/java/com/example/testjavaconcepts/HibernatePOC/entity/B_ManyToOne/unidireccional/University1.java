package com.example.testjavaconcepts.HibernatePOC.entity.B_ManyToOne.unidireccional;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class University1 {

    @Id
    private long id;

}

//  +------------+
//  | UNIVERSITY |
//  +------------+
//  |     ID     |
//  +------------+