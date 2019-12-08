package com.example.testjavaconcepts.ConcurrencyPOC.ProducerConsumer.CustomBlockingQueue.LocksAndConditions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CustomBlockingQueueWithLocksAndConditions<E> {

    final int max = 5;
    Queue<E> queue = new LinkedList<>();

    // Lock and Conditions
    ReentrantLock lock = new ReentrantLock();
    Condition notEmpty = lock.newCondition();
    Condition notFull= lock.newCondition();

    public void put(E item) throws InterruptedException {
        lock.lock();
        try{
            while(queue.size() == max){  // Si la cola esta llena esperar hasta
                notFull.await();        // Wait/Bloquearse hasta que venga una señal notFull
            }
            queue.add(item);      // Agrego el item a la cola
            notEmpty.signalAll(); // Emitimos la señal que no esta vacia
        }finally {
            lock.unlock();
        }
    }

    public E take() throws InterruptedException {
        lock.lock();
        try{
            while(queue.size() == 0){  // Si la cola esta vacia esperar hasta
                notEmpty.await();    // Wait/Bloquearse hasta que venga una señal notEmpty
            }
            E item = queue.remove();  // Consumo el item a la cola
            notFull.signalAll();      // Emitimos la señal que no esta llena
            return item;
        }finally {
            lock.unlock();
        }
    }
}
