package com.example.testjavaconcepts.CollectionsJava.Collection.Queue;

import com.example.testjavaconcepts.CollectionsJava.Collection.Queue.model.Customer;

import java.util.Queue;


public class Supermercado {

    private static Long caja = 0L;

    public static void main(String[] args) {

        ColaCustomers cola = new ColaCustomers();

        cola.clientReadyToPay(new Customer("Andres",150L));
        cola.clientReadyToPay(new Customer("Juan",120L));

        System.out.println(getCajaTotal(cola));

    }

    private static Long getCajaTotal(ColaCustomers cola) {
        while(hasPendingCustomers(cola)){
            Customer cliente = cola.atenderCliente();
            if(cliente == null) return 0L;
            caja += cliente.getMount();
        }
        return caja;
    }

    private static boolean hasPendingCustomers(ColaCustomers cola) {
        return cola.size() > 0;
    }


}
