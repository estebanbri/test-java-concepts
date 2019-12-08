package com.example.testjavaconcepts.ConcurrencyPOC.cave.producer_consumer_low_level;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

public class ConsumerTask implements Runnable {
    private static final Logger LOG = LoggerFactory.getLogger(ConsumerTask.class);

    private final Queue<Integer> sharedQueue;

    ConsumerTask(Queue<Integer> queue){
        this.sharedQueue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void consume() throws InterruptedException {
        Thread.sleep(100);
        synchronized (sharedQueue) {
            LOG.info("Consumer Thread running...");
            while (sharedQueue.isEmpty()) {
                LOG.info("LISTA VACIA no se puede consumir...");
                sharedQueue.wait();
            }
            int value = sharedQueue.poll();
            LOG.info("Valor consumido: " + value);
            LOG.info(sharedQueue.toString());
            sharedQueue.notifyAll(); // notify the producer
        }
        int random = ThreadLocalRandom.current().nextInt(500, 1000);
        Thread.sleep(random);
    }

}
