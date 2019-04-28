package com.example.testjavaconcepts.ConcurrencyPOC;

import org.springframework.scheduling.annotation.Async;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Concurrency {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //preJava5();
        //postJava5Runnable();
        //postJava5CallableFuture();
        //postJava5invokeAnyCallableFuture();
        //postJava5invokeAllCallableFuture();


        CompletableFuture
                .supplyAsync(()->postJava5CompletableFuture1())
                .thenApply(cadena -> postJava5CompletableFuture2());

    }

    private static void preJava5(){


        Runnable runnable = () -> {
            System.out.println("Thread: " + Thread.currentThread().getName());
        };

        // Ejecuto el runnable (task) en el thread actual (es decir main)
        runnable.run();

        // Seeds to the new Thread la task anterior
        Thread thread = new Thread(runnable);
        thread.start();

    }

    private static void postJava5Runnable(){
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Runnable runnable = () -> {
            System.out.println("Thread: " + Thread.currentThread().getName());
        };

        // Ejecuto el runnable (task) en el thread actual (es decir main)
        runnable.run();

        // Seeds to the executor la task anterior
        executor.submit(runnable); // submit(Runnable task)

        executor.shutdown(); // apago explicitamente porque los executor nunca terminan siempre quedan escuchando por nuevas tasks
    }

    private static void postJava5CallableFuture() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<Integer> callable = () -> {
            TimeUnit.SECONDS.sleep(5);
            return 132;
        };

        Future<Integer> future = executor.submit(callable);

        System.out.println("Future esta listo? " + future.isDone());

        Integer valor = future.get(); // La ejecucion del thread main se bloquea hasta en esta sentencia hasta que el future tenga el valor buscado

        System.out.println("Future esta listo? " + future.isDone());

        System.out.println(valor);

        executor.shutdown();
    }

    // Batch submiting multiples callables
    // invokeAny: this method blocks until the first callable terminates and returns the result of that callable.
    private static void postJava5invokeAnyCallableFuture() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<Integer> callable_5_segundos = () -> {
            TimeUnit.SECONDS.sleep(5);
            return 555;
        };
        Callable<Integer> callable_3_segundos = () -> {
            TimeUnit.SECONDS.sleep(3);
            return 333;
        };

        List<Callable<Integer>> listaCallables = Arrays.asList(
                callable_5_segundos,
                callable_3_segundos
        );

        Integer valor = executor.invokeAny(listaCallables);

        System.out.println(valor);

        executor.shutdown();
    }

    // Batch submiting multiples callables
    // invokeAll:
    private static void postJava5invokeAllCallableFuture() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<Integer> callable1 = () -> {
            return 555;
        };
        Callable<Integer> callable2 = () -> {
            return 333;
        };

        List<Callable<Integer>> listaCallables = Arrays.asList(
                callable1,
                callable2
        );

        List<Future<Integer>> futures = executor.invokeAll(listaCallables);

        for(Future<Integer> future : futures){
            Integer valor = future.get();
            System.out.println(valor);
        }

        executor.shutdown();
    }

    @Async
    private static String postJava5CompletableFuture1() {

        try{
            Thread.sleep(15000); // Simulo operacion que puede llevar mucho tiempo Ej: Call a un WS
        }catch(Exception w ){}

        return "ACEPTADO_1";
    }
    @Async
    private static String postJava5CompletableFuture2(){

        try{
            Thread.sleep(2000); // Simulo operacion que puede llevar mucho tiempo Ej: Call a un WS
        }catch(Exception e){}

        return "ACEPTADO_2";
    }




}
