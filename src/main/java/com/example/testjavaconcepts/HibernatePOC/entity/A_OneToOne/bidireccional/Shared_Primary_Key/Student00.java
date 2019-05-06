package com.example.testjavaconcepts.HibernatePOC.entity.A_OneToOne.bidireccional.Shared_Primary_Key;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Student00 {

    @Id
    private long id;

    @OneToOne(mappedBy="student")
    private Address address;

}

//  +------------+
//  |  STUDENT00 |
//  +------------+
//  |    ID      |
//  +------------+


