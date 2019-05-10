package com.example.testjavaconcepts.HibernatePOC.entity.A_OneToOne.bidireccional.Shared_Primary_Key;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String calle;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Student00 student;

    public Address() {
    }

    public Address(String calle) {
        this.calle = calle;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getCalle() { return calle; }
    public void setCalle(String calle) { this.calle = calle; }
    public Student00 getStudent() { return student; }
    public void setStudent(Student00 student) { this.student = student; }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", calle='" + calle + '\'' +
                '}';
    }
}


