package com.example.testjavaconcepts.HibernatePOC.entity.A_OneToOne.unidireccional.Foreign_Key;

import com.example.testjavaconcepts.HibernatePOC.entity.A_OneToOne.bidireccional.Foreign_Key.BIPasaporte;

import javax.persistence.*;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="pasaporte_fk")
    private Pasaporte pasaporte;

    public Cliente() {
    }

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Pasaporte getPasaporte() { return pasaporte; }
    public void setPasaporte(Pasaporte pasaporte) { this.pasaporte = pasaporte;}
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    @Override
    public String toString() {
        return "BiCliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", pasaporte=" + pasaporte +
                '}';
    }
}

//  +-----------------------+
//  |         Cliente       |
//  +--------+--------------+
//  |   ID   | PASAPORTE_FK |
//  +--------+--------------+

/**
 * Fetching strategy:
 *
 * It depends on whether you are using JPA or Hibernate.
 *
 * From the JPA 2.0 spec, the defaults are:
 *
 * OneToMany: LAZY
 * ManyToOne: EAGER
 * ManyToMany: LAZY
 * OneToOne: EAGER
 * And in hibernate, all is Lazy
 */
