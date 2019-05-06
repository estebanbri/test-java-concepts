package com.example.testjavaconcepts.HibernatePOC.entity.B_ManyToOne.unidireccional;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student1 {

    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name="UNIVERSITY_ID")
    private University1 university;

}

//  +------------------------+
//  |         STUDENT        |
//  +--------+---------------+
//  |    ID  | UNIVERSITY_ID |
//  +--------+---------------+
