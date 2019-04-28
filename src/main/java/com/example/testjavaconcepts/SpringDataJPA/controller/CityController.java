package com.example.testjavaconcepts.SpringDataJPA.controller;

import com.example.testjavaconcepts.SpringDataJPA.entity.City;
import com.example.testjavaconcepts.SpringDataJPA.entity.Persona;
import com.example.testjavaconcepts.SpringDataJPA.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityController {

    @Autowired
    ICityService cityService;

    /**
     * **********************
     *     CrudRepository
     * **********************
    */

    @GetMapping("/findByPopulation")
    public City findByPopulation(@RequestParam int population){

        City city = cityService.findByPopulation(population);

        return city;
    }

    @GetMapping("/showCitiesOrderedByNameDescending")
    public List<City>  findAllOrderedByNameDescending() {

        List<City> cities = (List<City>) cityService.findAllOrderedByNameDescending();

        return cities;
    }

    @GetMapping("/showCitiesEnding")
    public List<City> findCitiesNameEndsWith(@RequestParam String name) {

        List<City> cities = (List<City>) cityService.findByNameEndsWith(name);

        return cities;
    }

    @GetMapping("/countByName")
    public int countByName(@RequestParam String name) {

        int count =  cityService.countByName(name);

        return count;
    }


    @GetMapping("/findByPopulationAndName")
    public City findByPopulationAndName(@RequestParam int population, @RequestParam String name) {

        City city =  cityService.findByPopulationAndName(population, name);

        return city;
    }

    @GetMapping("/findByPopulationOrName")
    public City findByPopulationOrName(@RequestParam int population, @RequestParam String name) {

        City city =  cityService.findByPopulationOrName(population, name);

        return city;
    }

    @GetMapping("/findFirstByName")
    public City findFirstByName(@RequestParam String name) {

        City city =  cityService.findFirstByName(name);

        return city;
    }

    @GetMapping("/findTop3ByPopulation")
    public List<City> findTop3ByPopulation(@RequestParam int population) {

        List<City> city =  cityService.findTop3ByPopulation(population);

        return city;
    }

    @GetMapping("/findAllCrud")
    public List<City> findAllCrud() {

        List<City> city =  cityService.findAllCrud();

        return city;
    }

    @GetMapping("/findAllCrudPopulation")
    public List<Integer> findAllCrudPopulation() {

        List<Integer> populations =  cityService.findAllCrudPopulation();

        return populations;
    }

    @GetMapping("/findByNameEqualsToPrague")
    public List<City> findByNameEqualsToPrague() {

        List<City> cities =  cityService.findByNameEqualsToPrague();

        return cities;
    }

    @GetMapping("/getPersonaJoinCity")
    public List<Persona> getPersonaJoinCity() {

        List<Persona> personas =  cityService.getPersonaJoinCity();

        return personas;
    }




    /**
     * **********************
     *     Repository
     * **********************
     */

    @GetMapping("/findAll")
    public List<City> findAll() {

        List<City> cities = (List<City>) cityService.findAll();

        return cities;
    }


    @GetMapping("/deleteByPopulation")
    public int deleteById(@RequestParam int population) {

        int result =  cityService.deleteByPopulation(population);

        return result;
    }

    @GetMapping("/findAllOrderedByNameDescending2")
    public List<City> findAllOrderedByNameDescending2() {

        List<City> cities =  cityService.findAllOrderedByNameDescending2();

        return cities;
    }

    @GetMapping("/getPersonaJoinCityRepo")
    public List<Persona> getPersonaJoinCityRepo() {

        List<Persona> personas =  cityService.getPersonaJoinCityRepo();

        return personas;
    }
}