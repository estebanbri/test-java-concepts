package com.example.testjavaconcepts.SpringDataJPA.repository;

import com.example.testjavaconcepts.SpringDataJPA.entity.City;
import com.example.testjavaconcepts.SpringDataJPA.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Alternativa si no usas CrudRepository usas este Repository
 */
@Repository
public class CityRepositoryAux {

    @Autowired
    EntityManager em;

    public List<City> findAll(){
        Query query = em.createQuery("from City");
        List<City> cities = query.getResultList();
        return cities;
    }

    public int deleteByPopulation(int population){
        Query query = em.createQuery("delete City where population = :population");
        query.setParameter("population", population);
        int result = query.executeUpdate();
        return result;
    }

    public List<City> findAllOrderedByNameDescending2(){
        Query query = em.createNamedQuery("City.findAllOrderedByNameDescending");
        List<City> cities = query.getResultList();
        return cities;
    }

    public List<Persona> PERSONA_inner_join_CITY(){
        Query query = em.createQuery("FROM Persona p INNER JOIN p.city c");
        List<Persona> personas = query.getResultList();
        return personas;
    }
}
