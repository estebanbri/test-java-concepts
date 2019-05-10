package com.example.testjavaconcepts.HibernatePOC.entity.A_OneToOne.bidireccional.Foreign_Key;

import com.example.testjavaconcepts.HibernatePOC.entity.A_OneToOne.bidireccional.Shared_Primary_Key.Student00;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.List;

@RestController
public class Main2 {
    @Autowired
    EntityManager em;

    @GetMapping("/persist_BI_FK")
    @Transactional
    public String persist() {
        BiCliente cliente1 = new BiCliente("Esteban");
        BIPasaporte pasaporte1 = new BIPasaporte("AR");

        cliente1.setPasaporte(pasaporte1);
        pasaporte1.setCliente(cliente1);

        BiCliente cliente2 = new BiCliente("Josefina");
        BIPasaporte pasaporte2 = new BIPasaporte("ES");

        cliente2.setPasaporte(pasaporte2);
        pasaporte2.setCliente(cliente2);

        em.persist(cliente1);
        em.persist(cliente2);

        return "EJECUTADO CORRECTAMENTE... VER CONSOLA";
    }

    @GetMapping("/find_BI_FK.BiCliente")
    public String find1() {
        List<BiCliente> biCliente = em.createQuery("from BiCliente").getResultList();
        for(BiCliente b : biCliente){
            System.out.println(b);
        }
        return "EJECUTADO CORRECTAMENTE... VER CONSOLA";
    }

    @GetMapping("/find_BI_FK.BiPasaporte")
    public String find2() {
        List<BIPasaporte> biPasaportes = em.createQuery("from BIPasaporte").getResultList();
        for(BIPasaporte b : biPasaportes){
            System.out.println(b);
            System.out.println(b.getCliente()); // CASO BIDIRECCIONAL
        }
        return "EJECUTADO CORRECTAMENTE... VER CONSOLA";
    }
}
