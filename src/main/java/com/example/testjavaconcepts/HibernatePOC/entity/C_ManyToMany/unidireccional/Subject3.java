package com.example.testjavaconcepts.HibernatePOC.entity.C_ManyToMany.unidireccional;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Subject3 {

    @Id
    public Long id;

}
//  +------------+
//  | SUBJECT3   |
//  +------------+
//  |     ID     |
//  +------------+