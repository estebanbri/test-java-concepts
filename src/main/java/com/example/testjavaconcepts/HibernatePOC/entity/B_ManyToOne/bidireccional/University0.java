package com.example.testjavaconcepts.HibernatePOC.entity.B_ManyToOne.bidireccional;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class University0 {

    @Id
    private long id;

    @OneToMany(mappedBy = "university")
    private List<Student0> students;

}

//  +------------+
//  | UNIVERSITY1|
//  +------------+
//  |     ID     |
//  +------------+
