package com.example.testjavaconcepts.ConcurrencyPOC.CompletableFuturePOC;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

@SpringBootApplication
public class CompletableFuturePOC {

    // https://www.deadcoderising.com/java8-writing-asynchronous-code-with-completablefuture/

    static Logger log = LoggerFactory.getLogger(CompletableFuturePOC.class);

    static int compute(){
        log.info("compute");
        return 2;
    }

    static int compute(int a){
        log.info("compute(a)");
        return a;
    }

    static CompletableFuture<Integer> create(){
        // supplyAsync : Returns a new CompletableFuture that is asynchronously completed by a task running in the ForkJoinPool.commonPool() with the value obtained by calling the given Supplier.
        // supplyAsync takes a Supplier containing the code we want to execute asynchronously. If you've worked a bit with Futures in the past, you may wonder where the Executor went. If you want to, you can still define it as a second argument. However, if you leave it out it will be submitted to the ForkJoinPool.commonPool().
        return CompletableFuture.supplyAsync( () -> compute() );  // compute() correra en otro thread
    }

    static void attachingOneCallback(){
        // thenAccept : Returns a new CompletionStage that, when this stage completes normally, is executed with this stage's result as the argument to the supplied action.
        // thenAccept is one of many ways to add a callback. It takes a Consumer — in our case notify — which handles the result of the preceding computation when it's done.
        // thenAccept es un de los metodos que te permite Attachear un callback
        create()
                .thenAccept( data -> System.out.println(data) );
    }

    static void attachingTwoCallback(){
// thenAccept : Returns a new CompletionStage that, when this stage completes normally, is executed with this stage's result as the argument to the supplied action.
        // thenAccept is one of many ways to add a callback. It takes a Consumer — in our case notify — which handles the result of the preceding computation when it's done.
        // thenAccept es un de los metodos que te permite Attachear un callback
        create()
                .thenApply(a ->compute(a) ) // thenApply takes a Function which accepts a value, but also return one.
                .thenAccept(a -> compute()); // If you want to continue passing values from one callback to another, thenAccept won't cut it since Consumer doesn't return anything.
    }


    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(CompletableFuturePOC.class, args);
        log.info("main");
        computeAsync();

    }

// asd 1234
    @Async
    public static CompletableFuture<String> computeAsync(Integer i) throws InterruptedException {
        // do something slow - no change to this part
        int valor = (int)Math.random()+10*i;
        Thread.sleep(valor);
        // note: no need to wrap your code in a lambda/method reference,
        //       no need to bother about executor handling
        return CompletableFuture.completedFuture("my result" + i);
    }

    @Async
    public static void computeAsync() throws InterruptedException {
       log.info("Thread");
    }

    // ___Async : son Callback as a separate task using the async suffix

    @Async
    public <T> CompletableFuture<T> asyncOperation(T input) {

        System.out.println("working...");
        LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(5));
        System.out.println("done.");

        return CompletableFuture.completedFuture(input);
    }
}
@Configuration
@EnableAsync
class AppConfig {

}
