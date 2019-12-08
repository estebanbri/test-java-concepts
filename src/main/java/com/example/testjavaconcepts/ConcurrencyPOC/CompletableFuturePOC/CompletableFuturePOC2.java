package com.example.testjavaconcepts.ConcurrencyPOC.CompletableFuturePOC;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class CompletableFuturePOC2 {
    public static void main(String[] args)  {

        Supplier<String> supplier = () -> "hola".toUpperCase();
        String result1 = supplier.get();
        System.out.println(result1);

        Consumer<String> consumer = (str) -> System.out.println(str);
        consumer.accept("hola");

        Function<Integer, Integer> function = (operando) -> operando * 2;
        Integer result2 = function.apply(4);
        System.out.println(result2);



        System.out.println(Thread.currentThread().getName());

        CompletableFuture.runAsync(()-> {
            System.out.println(Thread.currentThread().getName());
        });

        CompletableFuture<String> cf = CompletableFuture.supplyAsync(()-> {
            dormir(5);
            return "Finalizado supplyAsync";
        });

        cf.whenCompleteAsync((resultado,e)->System.out.print(resultado)); // añade un callback para ejecutarlo cuando el futuro se complete

        System.out.println("Finalizado main");
    }

    private static void dormir(int segundos){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
