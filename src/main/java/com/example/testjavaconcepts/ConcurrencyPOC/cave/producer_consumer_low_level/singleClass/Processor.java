package com.example.testjavaconcepts.ConcurrencyPOC.cave.producer_consumer_low_level.singleClass;

import com.example.testjavaconcepts.ConcurrencyPOC.cave.producer_consumer_low_level.ConsumerTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Queue;

public class Processor {
    private static final Logger LOG = LoggerFactory.getLogger(Processor.class);
    Queue<Integer> queue;

    static final int LIMIT = 5;

    Processor(Queue<Integer> queue){
        this.queue = queue;
    }

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (queue) {
                LOG.info("Producer Thread running...");
                while(queue.size() == LIMIT){
                    LOG.info("LISTA COMPLETA no se puede producir...");
                    queue.wait();
                }
                value = value + 1;
                queue.add(value);
                LOG.info(queue.toString());
                queue.notifyAll(); // notify the cosumer Avisamos que se agrego un elemento a la estructura para aquel thread consumidor que este en wait() esperando por que haya al menos un elemento por consumir de la estructruda
                Thread.sleep(2000);
                LOG.info("Producer Thread corriendo nuevamente, i have re-gained control of this lock...");
            }
        }
    }

    public void consume() throws InterruptedException {
        Thread.sleep(1000);
        while (true) {
            synchronized (queue){
                LOG.info("Consumer Thread running...");
                while(queue.size() == 0){
                    LOG.info("LISTA VACIA no se puede consumir...");
                    queue.wait();
                }
                int value = queue.poll();
                LOG.info("Valor consumido: " + value);
                LOG.info(queue.toString());
                queue.notify(); // notify the producer
                Thread.sleep(1000);
            }
        }
    }
}
