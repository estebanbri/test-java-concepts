package com.example.testjavaconcepts.HibernatePOC.entity.bidireccional.ManyToMany;

import com.example.testjavaconcepts.HibernatePOC.entity.bidireccional.OneToOne.Curso1;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
public class Alumno2 {
    @Id
    private Long id1;

    private String nombre1;

    @ManyToMany(mappedBy="listAlumnos")
    private List<Curso2> listCurso;

}

