package com.example.testjavaconcepts.HibernatePOC.entity.C_ManyToMany.bidireccional;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class Student2 {

    @Id
    private long id;

    @ManyToMany
    @JoinTable(name = "STUDENT_SUBJECT",
            joinColumns = { @JoinColumn(name = "STUDENT_ID") },
            inverseJoinColumns = { @JoinColumn(name = "SUBJECT_ID") })
    private List<Subject2> subjects;

}

//  +------------+
//  | STUDENT2   |
//  +------------+
//  |     ID     |
//  +------------+

//  +---------------------------+
//  |        STUDENT_SUBJECT    |
//  +--------------+------------+
//  |  STUDENT_ID  | SUBJECT_ID |
//  +--------------+------------+