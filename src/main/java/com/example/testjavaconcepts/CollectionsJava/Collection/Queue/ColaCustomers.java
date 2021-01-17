package com.example.testjavaconcepts.CollectionsJava.Collection.Queue;

import com.example.testjavaconcepts.CollectionsJava.Collection.Queue.model.Customer;

import java.util.LinkedList;
import java.util.Queue;

public class ColaCustomers {

    private Queue<Customer> cola = new LinkedList();

    public void clientReadyToPay(Customer cliente) {
        cola.offer(cliente);
    }

    public Customer atenderCliente(){
        return cola.poll();
    }

    public int size(){
        return cola.size();
    }
}
