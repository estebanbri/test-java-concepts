package com.example.testjavaconcepts.CopyPropertiesPOC;

import java.util.List;

public class Fuente {

    private long id;
    private String nombre;
    private String apellido;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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
        sb.append("Apellido: ").append(this.apellido);
        sb.append(", ");
        sb.append("Telefonos: ").append(this.telefonos);
        sb.append("}");
        return sb.toString();
    }
}
