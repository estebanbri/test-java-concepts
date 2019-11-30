package com.example.testjavaconcepts.ConcurrencyPOC.wait;

public class Restaurant {

    Order order; // Package access

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        WaitPerson waitPerson = new WaitPerson(restaurant);
        Chef chef = new Chef(restaurant, waitPerson);
    }
}
