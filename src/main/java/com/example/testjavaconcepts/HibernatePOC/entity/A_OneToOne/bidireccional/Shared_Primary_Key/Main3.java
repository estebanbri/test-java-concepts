package com.example.testjavaconcepts.HibernatePOC.entity.A_OneToOne.bidireccional.Shared_Primary_Key;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.List;

@RestController
public class Main3 {

    @Autowired
    EntityManager em;

    @GetMapping("/persist_BI_SPK")
    @Transactional
    public String persist() {
        Student00 student1 = new Student00("Esteban");
        Address address1 = new Address("Brown");

        student1.setAddress(address1);
        address1.setStudent(student1);

        Student00 student2 = new Student00("Andres");
        Address address2 = new Address("Catamarca");

        student2.setAddress(address2);
        address2.setStudent(student2);

        em.persist(student1);
        em.persist(student2);

        return "VALORES INSERTADOS EN LAS TABLAS: STUDENT00 y ADDRESS...";
    }

    // Student00 --> Address
    @GetMapping("/find_BI_SPK.Student00")
    public String find1() {
        List<Student00> students = em.createQuery("from Student00").getResultList();
        for(Student00 s : students){
            System.out.println(s);
        }
        return "EJECUTADO CORRECTAMENTE... VER CONSOLA";
    }

    // Student00 <-- Address
    @GetMapping("/find_BI_SPK.Address")
    public String find2(){
     List<Address> addresses = em.createQuery("from Address").getResultList();
        for(Address address : addresses){
        System.out.println(address);
        System.out.println(address.getStudent()); // CASO BIDIRECCIONAL
        }
        return "EJECUTADO CORRECTAMENTE... VER CONSOLA";
    }
}
