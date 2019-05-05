package com.example.testjavaconcepts.HibernatePOC.entity.bidireccional.ManyToMany;

import com.example.testjavaconcepts.HibernatePOC.entity.bidireccional.OneToOne.Alumno1;

import javax.persistence.*;
import java.util.List;

@Entity
public class Curso2 {

    @Id
    private Long id2;

    private String nombre2;

    @ManyToMany
    @JoinTable(name="curso_alumno2",
            joinColumns=@JoinColumn(name="curso_id"),
            inverseJoinColumns=@JoinColumn(name="alumno_id"))
    List<Alumno2> listAlumnos;
}
