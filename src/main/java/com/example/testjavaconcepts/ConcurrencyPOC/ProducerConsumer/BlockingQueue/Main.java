package com.example.testjavaconcepts.ConcurrencyPOC.ProducerConsumer.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class Main {
    public static void main(String[] args) {

        //Creating BlockingQueue of size 5
        BlockingQueue<Mensaje> cola = new LinkedBlockingQueue<>(5);

        //starting producer to produce messages in queue
        new Thread(new Productor(cola)).start();
        //starting consumer to consume messages from queue
        new Thread(new Consumidor(cola)).start();
    }
}
