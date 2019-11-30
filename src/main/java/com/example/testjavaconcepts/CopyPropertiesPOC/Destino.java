package com.example.testjavaconcepts.CopyPropertiesPOC;

import java.util.List;

public class Destino {

    private long id;
    private String nombre;
    private List<String> telefonos;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<String> telefonos) {
        this.telefonos = telefonos;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("Id: ").append(this.id);
        sb.append(", ");
        sb.append("Nombre: ").append(this.nombre);
        sb.append(", ");
        sb.append("Telefonos: ").append(this.telefonos);
        sb.append("}");
        return sb.toString();
    }
}
