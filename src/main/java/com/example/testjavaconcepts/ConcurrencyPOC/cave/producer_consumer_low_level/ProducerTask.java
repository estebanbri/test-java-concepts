package com.example.testjavaconcepts.ConcurrencyPOC.cave.producer_consumer_low_level;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;


public class ProducerTask implements Runnable {
    private static final Logger LOG = LoggerFactory.getLogger(ProducerTask.class);
    
    private final Queue<Integer> sharedQueue;

    static final int LIMIT = 5;
    
    ProducerTask(Queue<Integer> queue){
        this.sharedQueue = queue;
    }

    @Override
    public void run() {
        int counter = 0;
        while (true) {
            try {
                produce(counter++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void produce(int counter) throws InterruptedException {

        synchronized (sharedQueue) {
            LOG.info("Producer Thread running...");
            while (sharedQueue.size() == LIMIT) {
                LOG.info("SHARED QUEUE FULL: no se puede producir...");
                sharedQueue.wait();
            }
            sharedQueue.add(counter);
            LOG.info(sharedQueue.toString());
            sharedQueue.notifyAll(); // notify the cosumer Avisamos que se agrego un elemento a la estructura para aquel thread consumidor que este en wait() esperando por que haya al menos un elemento por consumir de la estructruda
            LOG.info("Producer Thread corriendo nuevamente, i have re-gained control of this lock...");
        }
        int random = ThreadLocalRandom.current().nextInt(500, 1000);
        Thread.sleep(random); // Note that both threads use sleep() methods as well for simulating time delays in creating and consuming elements.
    }

}
