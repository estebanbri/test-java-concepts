package com.example.testjavaconcepts.HibernatePOC.entity.C_ManyToMany.unidireccional;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student3 {

    @Id
    private long id;


    @ManyToMany
    @JoinTable(name = "STUDENT_SUBJECT",
            joinColumns = { @JoinColumn(name = "STUDENT_ID") },
            inverseJoinColumns = { @JoinColumn(name = "SUBJECT_ID") })
    private List<Subject3> subjects;


}

//  +------------+
//  | STUDENT3   |
//  +------------+
//  |     ID     |
//  +------------+

//  +---------------------------+
//  |        STUDENT_SUBJECT    |
//  +--------------+------------+
//  |  STUDENT_ID  | SUBJECT_ID |
//  +--------------+------------+