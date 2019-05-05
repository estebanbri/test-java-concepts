package com.example.testjavaconcepts.HibernatePOC.entity.unidirecional.ManyToMany;

import javax.persistence.*;
import java.util.List;

@Entity
public class Curso3 {

    @Id
    private Long id2;

    private String nombre2;

    @ManyToMany
    @JoinTable(name="curso_alumno3",
            joinColumns=@JoinColumn(name="curso_id"),
            inverseJoinColumns=@JoinColumn(name="alumno_id"))
    List<Alumno3> listAlumnos;
}
