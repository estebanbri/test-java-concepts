package com.example.testjavaconcepts.ConcurrencyPOC.ProducerConsumer.CustomBlockingQueue.Wait_Notify;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 *  wait() y notify() y notifyAll() unicamente funcionan dentro de bloques syncrhonized y si o si sobre el mismo objeto usado de loc
 */

public class CustomBlockingQueueWithWait_Notify<E> {

    final int max = 5;
    Queue<E> queue = new LinkedList<>();

    public synchronized void put(E item) throws InterruptedException {
        while(queue.size() == max){  // Si la cola esta llena esperar hasta
            this.wait();        // Wait/Bloquearse hasta que venga una señal notFull
        }
        queue.add(item);      // Agrego el item a la cola
        this.notifyAll(); // Emitimos la señal que no esta vacia
    }

    public synchronized E take() throws InterruptedException {
        while(queue.size() == 0){  // Si la cola esta vacia esperar hasta
            this.wait();    // Wait/Bloquearse hasta que venga una señal notEmpty
        }
        E item = queue.remove();  // Consumo el item a la cola
        this.notifyAll();      // Emitimos la señal que no esta llena
        return item;
    }

}
