package com.example.testjavaconcepts.ConcurrencyPOC.cave.producer_consumer_low_level.singleClass;

import com.example.testjavaconcepts.ConcurrencyPOC.cave.producer_consumer_low_level.ProducerTask;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();
        Processor processor = new Processor(queue);

        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        producer.start();
        consumer.start();
    }
}
