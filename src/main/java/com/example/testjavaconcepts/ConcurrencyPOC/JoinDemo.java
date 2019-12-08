package com.example.testjavaconcepts.ConcurrencyPOC;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JoinDemo implements Runnable

{
    static Logger LOGGER = LoggerFactory.getLogger(JoinDemo.class);

    public void run()
    {
        Thread t = Thread.currentThread();
        LOGGER.info("Current thread: "
                + t.getName());

        // checks if current thread is alive
        LOGGER.info("Is Alive? "
                + t.isAlive());
    }

    public static void main(String args[]) throws Exception
    {
        Thread t = new Thread(new JoinDemo());
        t.start();

        // Waits for 1000ms this thread to die.
        t.join(1000);

        LOGGER.info("\nJoining after 1000"+
                " mili seconds: \n");
        LOGGER.info("Current thread: " +
                t.getName());


        // Checks if this thread is alive
        LOGGER.info("Is alive? " + t.isAlive());
    }
}
