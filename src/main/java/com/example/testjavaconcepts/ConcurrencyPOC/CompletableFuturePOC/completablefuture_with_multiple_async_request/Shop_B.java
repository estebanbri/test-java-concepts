package com.example.testjavaconcepts.ConcurrencyPOC.CompletableFuturePOC.completablefuture_with_multiple_async_request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Shop_B extends Shop{

    Logger LOGGER = LoggerFactory.getLogger(Shop_A.class);

    @Override
    public String getPrecio(String producto) {
        // Aca iria el restTemplate para llamar al web service de Shop B
        LOGGER.info("Obteniendo precio de Shop B");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        switch (producto){
            case "television": return "$400.0";
            default: return "Producto no exite...";
        }
    }
}
