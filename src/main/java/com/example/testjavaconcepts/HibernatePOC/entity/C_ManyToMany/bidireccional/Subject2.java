package com.example.testjavaconcepts.HibernatePOC.entity.C_ManyToMany.bidireccional;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Subject2 {

    @Id
    private long id;

    @ManyToMany(mappedBy="subjects")
    private List<Student2> students;

}

//  +------------+
//  | SUBJECT2   |
//  +------------+
//  |     ID     |
//  +------------+
