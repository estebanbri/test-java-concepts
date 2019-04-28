package com.example.testjavaconcepts.SpringDataJPA.service;

import com.example.testjavaconcepts.SpringDataJPA.entity.City;
import com.example.testjavaconcepts.SpringDataJPA.entity.Persona;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ICityService {

     City findByPopulation(int population);

     List<City> findAllOrderedByNameDescending();

     List<City> findByNameEndsWith(String name);

     List<City> findAll();

     @Transactional
     int deleteByPopulation(int population);

     List<City> findAllOrderedByNameDescending2();

     int countByName(String name);

     City findByPopulationAndName(int population, String name);

     City findByPopulationOrName(int population, String name);

     City findFirstByName(String name); // identico a:  City findTopByName(String name);

     List<City> findTop3ByPopulation(int population);

     List<City> findAllCrud();

     List<Integer> findAllCrudPopulation();

     List<City> findByNameEqualsToPrague();

     List<Persona> getPersonaJoinCity();

     List<Persona> getPersonaJoinCityRepo();
}