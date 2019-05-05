package com.example.testjavaconcepts.HibernatePOC.entity.bidireccional.OneToOne;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Alumno1 {

    @Id
    private Long id1;

    private String nombre1;

    @OneToOne(mappedBy = "alumno")
    private Curso1 curso;

}

// +---------------------------+
// |           ALUMNO          |
// +-----+---------+-----------+
// | ID1 | NOMBRE1 | CURSO_ID2 |
// +-----+---------+-----------+
