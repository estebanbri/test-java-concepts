package com.example.testjavaconcepts.ConcurrencyPOC.CompletableFuturePOC.completablefuture_with_multiple_async_request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Shop_A extends Shop{

    Logger LOGGER = LoggerFactory.getLogger(Shop_A.class);

    @Override
    public String getPrecio(String producto) {
        // Aca iria el restTemplate para llamar al web service de Shop A
        LOGGER.info("Obteniendo precio de Shop A");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        switch (producto){
            case "television": return "$200.0";
            default: return "Producto no exite...";
        }
    }
}