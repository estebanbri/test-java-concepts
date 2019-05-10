package com.example.testjavaconcepts.HibernatePOC.entity.A_OneToOne.unidireccional.Foreign_Key;

import com.example.testjavaconcepts.HibernatePOC.entity.A_OneToOne.bidireccional.Foreign_Key.BIPasaporte;
import com.example.testjavaconcepts.HibernatePOC.entity.A_OneToOne.bidireccional.Foreign_Key.BiCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.List;

@RestController
public class Main {

    @Autowired
    EntityManager em;

    @GetMapping("/persist_UNI_FK")
    @Transactional
    public String persist() {
        Cliente cliente1 = new Cliente("Esteban");
        Pasaporte pasaporte1 = new Pasaporte("AR");

        cliente1.setPasaporte(pasaporte1);

        Cliente cliente2 = new Cliente("Josefina");
        Pasaporte pasaporte2 = new Pasaporte("ES");

        cliente2.setPasaporte(pasaporte2);

        em.persist(cliente1);
        em.persist(cliente2);

        return "EJECUTADO CORRECTAMENTE... VER CONSOLA";
    }

    // Cliente --> Pasaporte
    @GetMapping("/find_UNI_FK.Cliente")
    public String find1() {
        List<Cliente> cliente = em.createQuery("from Cliente").getResultList();
        for(Cliente b : cliente){
            System.out.println(b);
        }
        return "EJECUTADO CORRECTAMENTE... VER CONSOLA";
    }
}

