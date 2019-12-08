package com.example.testjavaconcepts.ConcurrencyPOC.ConcurrencyJoinWaitNofityYield;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Join_Wait_Notify_YIELD {
    static Logger LOGGER = LoggerFactory.getLogger(Join_Wait_Notify_YIELD.class);

    private static final WorkerB workerB = new WorkerB();

    public static void main(String... args) throws InterruptedException {

        workerB.start();

        synchronized (workerB) {
            while (workerB.sum == 0) {
                LOGGER.debug("Waiting for ThreadB to complete...");
                workerB.wait();
            }

            LOGGER.debug("ThreadB has completed. Sum from that thread is: " + workerB.sum);
        }
    }



}
