package com.example.testjavaconcepts.HibernatePOC.entity.unidirecional.OneToOne;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Curso {

    @Id
    private Long id2;

    private String nombre2;

}

// +---------------+
// |    CURSO      |
// +-----+---------+
// | ID2 | NOMBRE2 |
// +-----+---------+
