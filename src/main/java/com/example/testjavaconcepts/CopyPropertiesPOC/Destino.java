package com.example.testjavaconcepts.CopyPropertiesPOC;

public class Destino {

    private long id;
    private String nombre;

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

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("Id: ").append(this.id);
        sb.append(",");
        sb.append("Nombre: ").append(this.nombre);
        sb.append("}");
        return sb.toString();
    }
}
