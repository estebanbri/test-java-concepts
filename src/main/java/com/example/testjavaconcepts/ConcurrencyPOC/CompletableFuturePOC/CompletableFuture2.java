package com.example.testjavaconcepts.ConcurrencyPOC.CompletableFuturePOC;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CompletableFuture2 {
    private static final Logger LOGGER = LoggerFactory.getLogger(CompletableFuture2.class);

    public static void main(String[] args) {

        LOGGER.info("Entrando a main");

        ExecutorService threadpool = Executors.newFixedThreadPool(3);

        CompletableFuture<Void> cf =
                CompletableFuture
                        .supplyAsync(()-> obtenerSaldoAsync(),threadpool)           // Supplier
                        .thenApplyAsync(saldo -> duplicarSaldo(saldo),threadpool)   // Function
                        .thenAcceptAsync(saldo-> imprimirSaldo(saldo),threadpool)   // Consumer
                        .thenRun(()-> threadpool.shutdown());                       // Runnable

        LOGGER.info("Saliendo de main");
    }

    public static int obtenerSaldoAsync(){
        LOGGER.info("Obteniendo saldo ...");
        dormir(2);
        int saldo = 200;
        LOGGER.info("Saldo inicial = " + saldo);
        return saldo;
    }

    public static int duplicarSaldo(int saldo){
        LOGGER.info("Duplicando saldo ...");
        dormir(2);
        return saldo * 2;
    }

    public static void imprimirSaldo(int operando){
        LOGGER.info("Imprimiendo saldo ...");
        dormir(2);
        LOGGER.info("Saldo final = " + operando);
    }


    public static void dormir(int segundos) {
        try {
            TimeUnit.SECONDS.sleep(segundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
