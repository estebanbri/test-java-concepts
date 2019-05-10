package com.example.testjavaconcepts.HibernatePOC.entity.A_OneToOne.bidireccional.Foreign_Key;

import javax.persistence.*;

@Entity
public class BIPasaporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lugar;

    @OneToOne
    BiCliente cliente;

    public BIPasaporte() {
    }

    public BIPasaporte(String lugar) {
        this.lugar = lugar;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public BiCliente getCliente() {
        return cliente;
    }
    public void setCliente(BiCliente cliente) {
        this.cliente = cliente;
    }
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

