package com.example.testjavaconcepts.HibernatePOC.entity.A_OneToOne.bidireccional.Shared_Primary_Key;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Address {

    @Id
    private long id;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Student00 student;

}


//  +----------+
//  |  Address |
//  +----------+
//  |    ID    |
//  +----------+