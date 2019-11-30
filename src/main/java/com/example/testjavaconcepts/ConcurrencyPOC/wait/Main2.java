package com.example.testjavaconcepts.ConcurrencyPOC.wait;

import com.example.testjavaconcepts.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main2 {
    public static void main(String[] args) {
        Main2 m = new Main2();
        m.send("asd");
        m.receive();
    }
    Logger Log = LoggerFactory.getLogger(Main.class);

    private String packet;

    // True if receiver should wait
    // False if sender should wait
    private boolean transfer = true;

    public synchronized void send(String packet) {
        while (!transfer) {
            try {
                wait();
            } catch (InterruptedException e)  {
                Thread.currentThread().interrupt();
                Log.error("Thread interrupted", e);
            }
        }
        transfer = false;

        this.packet = packet;
        notifyAll();
    }

    public synchronized String receive() {
        while (transfer) {
            try {
                wait();
            } catch (InterruptedException e)  {
                Thread.currentThread().interrupt();
                Log.error("Thread interrupted", e);
            }
        }
        transfer = true;

        notifyAll();
        return packet;
    }
}
