package com.example.testjavaconcepts.HibernatePOC.entity.B_ManyToOne.bidireccional;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student0 {

    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name="UNIVERSITY_ID")
    private University0 university;
    
}

//  +------------------------+
//  |         STUDENT1       |
//  +--------+---------------+
//  |    ID  | UNIVERSITY_ID |
//  +--------+---------------+