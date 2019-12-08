package com.example.testjavaconcepts.ConcurrencyPOC.ProducerConsumer.BlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;

public class Productor implements Runnable {

    BlockingQueue<Mensaje> queue;
    Logger LOGGER = LoggerFactory.getLogger(Productor.class);

    public Productor(BlockingQueue<Mensaje> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        //produce messages
        for(int i = 0; i < 10 ; i++){
            Mensaje mensaje = new Mensaje("Mensaje-" + i);
            try {
                queue.put(mensaje);
                Thread.sleep(1000);
                LOGGER.info("[Producer] Put : "+ mensaje.getMensaje());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        //adding exit message
        Mensaje mensaje = new Mensaje("exit");
        try {
            queue.put(mensaje);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
