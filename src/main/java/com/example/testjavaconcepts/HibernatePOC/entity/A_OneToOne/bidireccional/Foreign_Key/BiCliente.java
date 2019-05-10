package com.example.testjavaconcepts.HibernatePOC.entity.A_OneToOne.bidireccional.Foreign_Key;

import javax.persistence.*;

@Entity
public class BiCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToOne(cascade= CascadeType.ALL, mappedBy = "cliente")
    @JoinColumn(name="pasaporte_fk")
    private BIPasaporte pasaporte;

    public BiCliente() {
    }

    public BiCliente(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public BIPasaporte getPasaporte() { return pasaporte; }
    public void setPasaporte(BIPasaporte pasaporte) { this.pasaporte = pasaporte;}
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