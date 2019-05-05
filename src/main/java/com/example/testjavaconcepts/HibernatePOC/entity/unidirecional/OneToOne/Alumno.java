package com.example.testjavaconcepts.HibernatePOC.entity.unidirecional.OneToOne;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Alumno {

    @Id
    private Long id1;

    private String nombre1;

    @OneToOne
    @JoinColumn(name= "ID2_PK")
    private Curso curso;

}

// +---------------------------+
// |           ALUMNO          |
// +-----+---------+-----------+
// | ID1 | NOMBRE1 |   ID2_PK  |
// +-----+---------+-----------+
