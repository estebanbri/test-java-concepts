package com.example.testjavaconcepts.SpringDataJPA.service;

import com.example.testjavaconcepts.SpringDataJPA.entity.City;
import com.example.testjavaconcepts.SpringDataJPA.entity.Persona;
import com.example.testjavaconcepts.SpringDataJPA.repository.CityRepositoryAux;
import com.example.testjavaconcepts.SpringDataJPA.repository.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService implements ICityService {

    @Autowired
    private ICityRepository repository;

    @Autowired
    private CityRepositoryAux repositoryAux;


    //
    //     CrudRepository
    //

    @Override
    public City findByPopulation(int population) {
        City city = repository.findByPopulation(population);
        return city;
    }

    @Override
    public List<City> findAllOrderedByNameDescending() {

        List<City> cities = (List<City>) repository.findAllOrderedByNameDescending();
        return cities;
    }

    @Override
    public List<City> findByNameEndsWith(String name) {

        List<City> cities = (List<City>) repository.findByNameEndsWith(name);
        return cities;
    }

    @Override
    public int countByName(String name) {
        int count = repository.countByName(name);
        return count;
    }

    @Override
    public City findByPopulationAndName(int population, String name) {
        City city = repository.findByPopulationAndName(population,name);
        return city;
    }

    @Override
    public City findByPopulationOrName(int population, String name) {
        City city = repository.findByPopulationOrName(population, name);
        return city;
    }

    @Override
    public City findFirstByName(String name) {
        City city = repository.findFirstByName(name);
        return city;
    }

    @Override
    public List<City> findTop3ByPopulation(int population) {
       List<City> cities = repository.findTop3ByPopulation(population);
       return cities;
    }

    @Override
    public List<City> findAllCrud() {
        List<City> cities = repository.findAllCrud();
        return cities;
    }

    @Override
    public List<Integer> findAllCrudPopulation() {
        List<Integer> populations = repository.findAllCrudPopulation();
        return populations;
    }

    @Override
    public List<City> findByNameEqualsToPrague() {
        List<City> city = repository.findByNameEqualsToPrague();
        return city;
    }

    @Override
    public List<Persona> getPersonaJoinCity(){
        List<Persona> personas = repository.getPersonaJoinCity();
        return personas;
    }

    //
    //      REPOSITORY
    //

    @Override
    public List<City> findAll(){
        List<City> cities = (List<City>) repositoryAux.findAll();
        return cities;
    }

    @Override
    public int deleteByPopulation(int population) {
        int result = repositoryAux.deleteByPopulation(population);
        return result;
    }

    @Override
    public List<City> findAllOrderedByNameDescending2() {
        List<City> cities = repositoryAux.findAllOrderedByNameDescending2();
        return cities;
    }

    @Override
    public List<Persona> getPersonaJoinCityRepo() {
        List<Persona> personas = repositoryAux.PERSONA_inner_join_CITY();
        return personas;
    }
}