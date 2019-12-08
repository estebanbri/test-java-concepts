package com.example.testjavaconcepts.ConcurrencyPOC.ProducerConsumer.BlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;

public class Consumidor implements Runnable {

    BlockingQueue<Mensaje> queue;
    Logger LOGGER = LoggerFactory.getLogger(Productor.class);

    public Consumidor(BlockingQueue<Mensaje> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Mensaje mensaje;
            while (!((mensaje = queue.take()).getMensaje().equals("exit"))){
                Thread.sleep(2000);
                LOGGER.info("[Consumer] Take : "+ mensaje.getMensaje());
            }
        }catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
