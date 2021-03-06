package com.example.testjavaconcepts.HibernatePOC.entity.A_OneToOne.unidireccional.Foreign_Key;

import com.example.testjavaconcepts.HibernatePOC.entity.A_OneToOne.bidireccional.Foreign_Key.BiCliente;

import javax.persistence.*;

@Entity
public class Pasaporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lugar;

    public Pasaporte() {
    }

    public Pasaporte(String lugar) {
        this.lugar = lugar;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getLugar() { return lugar; }
    public void setLugar(String lugar) { this.lugar = lugar; }

    @Override
    public String toString() {
        return "BIPasaporte{" +
                "id=" + id +
                ", lugar='" + lugar + '\'' +
                '}';
    }
}

//  +------------+
//  |  Pasaporte |
//  +------------+
//  |     ID     |
//  +------------+
