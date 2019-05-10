package com.example.testjavaconcepts.HibernatePOC.entity.A_OneToOne.bidireccional.Shared_Primary_Key;

import javax.persistence.*;

@Entity
public class Student00 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;

    @OneToOne(mappedBy = "student",  cascade = CascadeType.ALL)
    private Address address;

    public Student00() {
    }

    public Student00(String nombre) {
        this.nombre = nombre;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

    @Override
    public String toString() {
        return "Student00{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", address=" + address +
                '}';
    }
}



