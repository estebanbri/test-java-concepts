package com.example.testjavaconcepts.SpringDataJPA.repository;

import com.example.testjavaconcepts.SpringDataJPA.entity.City;
import com.example.testjavaconcepts.SpringDataJPA.entity.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICityRepository extends CrudRepository<City, Long> {

    City findByPopulation(int population);

    int countByName(String name);

    City findByPopulationAndName(int population, String name);

    City findByPopulationOrName(int population, String name);

    City findFirstByName(String name); // identico a:  City findTopByName(String name);

    List<City> findTop3ByPopulation(int population);

    // retorna la ciudad con menor cantidad de population
    City findTopByOrderByPopulationDesc();

    // @NamedQuery -> findAllOrderedByNameDescending
    List<City> findAllOrderedByNameDescending();

    @Query("from City c where c.name = 'Prague'")
    List<City> findByNameEqualsToPrague();

    @Query("from City c where c.name like %:chars")
    List<City> findByNameEndsWith(String chars);

    @Query("from City c")
    List<City> findAllCrud();

    @Query("select c.population from City c")
    List<Integer> findAllCrudPopulation();

    @Query("FROM Persona p INNER JOIN p.city c") // PERSONA INNER_JOIN CITY
    List<Persona> getPersonaJoinCity();



}