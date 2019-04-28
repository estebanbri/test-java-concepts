package com.example.testjavaconcepts.ExceptionPOC;

class ApiError{

    private String mensaje;
    private String mensajeAlDesarrollador;

    ApiError(){

    }

    ApiError(String mensaje, String mensajeAlDesarrollador){
        this.mensaje = mensaje;
        this.mensajeAlDesarrollador = mensajeAlDesarrollador;
    }

    public String getMensajeAlDesarrollador() {
        return mensajeAlDesarrollador;
    }

    public void setMensajeAlDesarrollador(String mensajeAlDesarrollador) {
        this.mensajeAlDesarrollador = mensajeAlDesarrollador;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "MiExepcion{" +
                "mensaje='" + mensaje + '\'' +
                ", mensajeAlDesarrollador='" + mensajeAlDesarrollador + '\'' +
                '}';
    }
}