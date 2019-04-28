package com.example.testjavaconcepts.GsonPOC;

import com.google.gson.Gson;

public class GsonPOC {

    public static void main(String[] args) {
        GsonPOC pojo = new GsonPOC();
        pojo.setNombre("Esteban");

        System.out.print(new Gson().toJson(pojo));

    }


    private String nombre;



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }




}
