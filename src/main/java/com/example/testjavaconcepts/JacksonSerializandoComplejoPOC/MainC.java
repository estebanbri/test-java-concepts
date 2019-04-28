package com.example.testjavaconcepts.JacksonSerializandoComplejoPOC;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MainC {
    BigDecimal b;

    public static void main(String[] args) throws IOException {

        C c1 = new C();
        c1.setCantidadPuertas(1);
        C c2 = new C();
        c2.setMarca("ASD");
        c2.setModelo("ASDSAD");


        List<C> listaC1 = new ArrayList();
        List<C> listaC2 = new ArrayList();
        listaC1.add(c1);
        listaC2.add(c2);

        B b1 = new B();
        b1.setC(listaC1);

        B b2 = new B();
        b2.setC(listaC2);
        b2.setType("OUTPUT");

        List<B> listB = new ArrayList();
        listB.add(b1);
        listB.add(b2);

        A a1 = new A();
        a1.setField(listB);
        a1.setResultCode(11);
        a1.setRet_status(22);
        a1.setService_name("HOLA");


        String json1 = new ObjectMapper().writeValueAsString(a1);
        System.out.println(json1);
    }
}

class A{
    @JsonProperty("TABLE")
    List<B> table;
    private String service_name;
    private Integer resultCode;
    private Integer ret_status;

    public List<B> getTable() {
        return table;
    }

    public void setField(List<B> table) {
        this.table = table;
    }
    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }
    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public Integer getRet_status() {
        return ret_status;
    }

    public void setRet_status(Integer ret_status) {
        this.ret_status = ret_status;
    }

}

@JsonInclude(JsonInclude.Include.NON_NULL)
class B{
    @JsonProperty("RECORD")
    List<C> c;
    @JsonProperty("TYPE")
    String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<C> getC() {
        return c;
    }

    public void setC(List<C> c) {
        this.c = c;
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
class C{
    private String marca;
    private Integer cantidadPuertas;
    private String modelo;

    C(){}

    public C(String marca, Integer cantidadPuertas, String modelo) {
        this.marca = marca;
        this.cantidadPuertas = cantidadPuertas;
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getCantidadPuertas() {
        return cantidadPuertas;
    }

    public void setCantidadPuertas(Integer cantidadPuertas) {
        this.cantidadPuertas = cantidadPuertas;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
