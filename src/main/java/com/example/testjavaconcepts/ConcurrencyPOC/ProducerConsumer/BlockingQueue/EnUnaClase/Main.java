package com.example.testjavaconcepts.ConcurrencyPOC.ProducerConsumer.BlockingQueue.EnUnaClase;

import com.example.testjavaconcepts.ConcurrencyPOC.ProducerConsumer.BlockingQueue.Consumidor;
import com.example.testjavaconcepts.ConcurrencyPOC.ProducerConsumer.BlockingQueue.Mensaje;
import com.example.testjavaconcepts.ConcurrencyPOC.ProducerConsumer.BlockingQueue.Productor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        //Creating BlockingQueue of size 5
        BlockingQueue<Mensaje> queue = new LinkedBlockingQueue<>(5);

        Runnable productor = () -> {
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
        };

        Runnable consumidor = () -> {
            try {
                Mensaje mensaje;
                while (!((mensaje = queue.take()).getMensaje().equals("exit"))){
                    Thread.sleep(2000);
                    LOGGER.info("[Consumer] Take : "+ mensaje.getMensaje());
                }
            }catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        //starting producer to produce messages in queue
        new Thread(productor).start();
        //starting consumer to consume messages from queue
        new Thread(consumidor).start();
    }
}
