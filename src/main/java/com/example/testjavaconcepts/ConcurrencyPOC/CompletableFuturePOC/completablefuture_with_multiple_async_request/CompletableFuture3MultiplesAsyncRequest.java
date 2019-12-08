package com.example.testjavaconcepts.ConcurrencyPOC.CompletableFuturePOC.completablefuture_with_multiple_async_request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class CompletableFuture3MultiplesAsyncRequest {
    static Logger LOGGER = LoggerFactory.getLogger(CompletableFuture3MultiplesAsyncRequest.class);
    public static void main(String[] args) {
        List<Shop> shops = Arrays.asList(
                new Shop_A(),
                new Shop_B());

        List<String> precios = encontrarPrecios(shops, "television");

        LOGGER.info(precios.toString());

    }

    private static List<String> encontrarPrecios(List<Shop> shops, String producto){
        List<CompletableFuture<String>> preciosFutures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(()-> shop.getPrecio(producto)))
                .collect(Collectors.toList());

        return preciosFutures.stream()
                .map(CompletableFuture::join)  // con esto esperamo a que todos los threads se completen es como usar get() pero la ventaja del metodo join() de CompletableFuture es que no tenes que encerrarlo en try-catch, es decir retornarrá el tipo T que envuelve el CompletableFuture<T>
                .collect(Collectors.toList());
    }
}






