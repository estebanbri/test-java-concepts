package com.example.testjavaconcepts.JacksonJack8Features;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.time.LocalDate;

public class ClassA {

    ObjectMapper objectMapper = new ObjectMapper();

    {
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    private LocalDate fecha;

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void m () throws IOException {
            String json1 = "{\n" +
                    "  \"fecha\": \"2014-12-20\"\n" +
                    "}";
        ClassA a = new ClassA();
            a = objectMapper.readValue(json1, ClassA.class);
            System.out.println(a.getFecha());
        a.setFecha(LocalDate.now());
        LocalDate hoy = a.getFecha();
        String json = objectMapper.writeValueAsString(hoy);
        System.out.println(json);
    }



}
