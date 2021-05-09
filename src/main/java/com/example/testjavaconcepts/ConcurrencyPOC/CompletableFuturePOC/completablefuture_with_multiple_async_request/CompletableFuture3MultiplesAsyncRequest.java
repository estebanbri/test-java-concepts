package com.example.testjavaconcepts.ConcurrencyPOC.CompletableFuturePOC.completablefuture_with_multiple_async_request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/*
 The join() method is similar to get().
 using join() instead of get() to avoid handling of checked exceptions.
 The only difference is that it throws an unchecked exception if the underlying CompletableFuture completes exceptionally.
  */

public class CompletableFuture3MultiplesAsyncRequest {
    static Logger LOGGER = LoggerFactory.getLogger(CompletableFuture3MultiplesAsyncRequest.class);
    public static void main(String[] args) {
        List<Shop> shops = Arrays.asList(
                new Shop_A(),
                new Shop_B());

        List<String> precios1 = encontrarPreciosAsyncBlocking(shops, "television");
        List<String> precios2 = encontrarPreciosAsyncNonBlocking(shops, "television");
        String precio3 = encontrarPrecioAsyncNonBlocking(shops, "television");

        LOGGER.info(precios1.toString());
        LOGGER.info(precios2.toString());
        LOGGER.info(precio3);
    }

    private static List<String> encontrarPreciosAsyncBlocking(List<Shop> shops, String producto){
        List<CompletableFuture<String>> preciosFutures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(()-> shop.getPrecio(producto)))
                .collect(Collectors.toList());

        return preciosFutures.stream()
                .map(CompletableFuture::join)  // con esto esperamo a que todos los threads se completen es como usar get() pero la ventaja del metodo join() de CompletableFuture es que no tenes que encerrarlo en try-catch, es decir retornarrá el tipo T que envuelve el CompletableFuture<T>
                .collect(Collectors.toList());
    }

    // CompletableFuture.allOf: static method allows to wait for completion of all of the Futures.
    // The allOf method has limitation that it does not return the combined results of all Futures. We you have to manually combine the results from Futures
    // No es bloqueante porque al llamar join() ya los features estan completados. Si no hubieras hecho el allOf
    private static List<String> encontrarPreciosAsyncNonBlocking(List<Shop> shops, String producto){
        // Consulto todos los precios asynchronously
        List<CompletableFuture<String>> preciosFutures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(()-> shop.getPrecio(producto)))
                .collect(Collectors.toList());

        // Create a combined Future using allOf()
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(preciosFutures.toArray(new CompletableFuture[preciosFutures.size()]));

        // When all the Futures are completed, call `future.join()` to get their results and collect the results in a list
        CompletableFuture<List<String>> res =
                allFutures.thenApply( v -> preciosFutures.stream()
                        .map(future -> future.join())  // will not block porque los features ya estan completados gracias al allOf
                        .collect(Collectors.toList()));

        return res.join();
    }

    // CompletableFuture.anyOf : espera al primer future del array se complete y lo retorna.
    private static String encontrarPrecioAsyncNonBlocking(List<Shop> shops, String producto){
        // Consulto todos los precios asynchronously
        List<CompletableFuture<String>> preciosFutures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(()-> shop.getPrecio(producto)))
                .collect(Collectors.toList());

        // Create a combined Future using allOf()
        CompletableFuture<Object> anyFutures = CompletableFuture.anyOf(preciosFutures.toArray(new CompletableFuture[preciosFutures.size()]));

        return (String) anyFutures.join(); // Will not block - porque cuando llega aqui ya se ha resuelto cualquiera de los features gracias al anyof
    }




}






