package com.example.testjavaconcepts.ConcurrencyPOC.simultaneous_call_syncronous_method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {
    public static void main(String[] args) {
        // Ejemplo: t1 va a dormir por 10000L milis y los demas thread
        // vna a tener que esperar hasta que t1 termine
        // el bloque syncrhonize (es decir que cada cliente va a tener un loading
        // esperando que se realize el proceso en forma de cola FIFO
        // Por eso un bloque sincronizado termina matando la concurrencia
        // porque ya pasa a ser un procesamiento lineal no concurrente, como cuando
        // vas a la cola de un supermercado
        Runnable r = new MyRunnable(new A());
        new Thread(r,"t1").start();
        new Thread(r,"t2").start();
        new Thread(r,"t3").start();
        new Thread(r,"t4").start();
    }
    private static class MyRunnable implements Runnable {

        private A a;

        public MyRunnable(A a){
            this.a = a;
        }

        @Override
        public void run() {
            a.m1();
        }
    }

}
class A {
    private static final Logger log = LoggerFactory.getLogger(A.class);
    void m1(){
        synchronized (this){
            log.info(Thread.currentThread().getName());
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
