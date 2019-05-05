package com.example.testjavaconcepts.HibernatePOC.entity.bidireccional.OneToOne;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Curso1 {

    @Id
    private Long id2;

    private String nombre2;

    @OneToOne
    @JoinColumn(name="PK")
    Alumno1 alumno;

}

// +---------------+
// |    CURSO      |
// +-----+---------+
// | ID2 | NOMBRE2 |
// +-----+---------+
