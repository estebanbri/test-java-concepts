package com.example.testjavaconcepts.ConcurrencyPOC.ConcurrencyJoinWaitNofityYield;

class WorkerB extends Thread {
    int sum;

    @Override
    public void run() {
        synchronized (this) {
            int i = 0;
            while (i < 100000) {
                sum += i;
                i++;
            }
            notify();
        }
    }
}
