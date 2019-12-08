package com.example.testjavaconcepts.ConcurrencyPOC.cave.wait_notify;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Processor processor = new Processor();

        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    processor.m1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    processor.m2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join(); // esperamos a que termine la ejecucion de  el thread-1 para continuar la ejecucion de thread-main
        t2.join(); // esperamos a que termine la ejecucion de  el thread-2 para continuar la ejecucion de thread-main
    }
}
