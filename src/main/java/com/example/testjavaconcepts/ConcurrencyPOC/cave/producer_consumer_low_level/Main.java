package com.example.testjavaconcepts.ConcurrencyPOC.cave.producer_consumer_low_level;

//https://howtodoinjava.com/java/multi-threading/wait-notify-and-notifyall-methods/
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Queue<Integer> queue = new LinkedList<>();

        Thread producer = new Thread(new ProducerTask(queue));

        Thread consumer = new Thread(new ConsumerTask(queue));

        producer.start();
        consumer.start();
    }
}
