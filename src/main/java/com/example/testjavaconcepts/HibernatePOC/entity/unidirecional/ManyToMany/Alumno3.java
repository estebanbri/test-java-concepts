package com.example.testjavaconcepts.HibernatePOC.entity.unidirecional.ManyToMany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Alumno3 {
    @Id
    private Long id1;

    private String nombre1;

}
