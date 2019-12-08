package com.example.testjavaconcepts.ConcurrencyPOC.ProducerConsumer.CustomBlockingQueue.Wait_Notify;

import com.example.testjavaconcepts.ConcurrencyPOC.ProducerConsumer.BlockingQueue.Mensaje;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    static Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        CustomBlockingQueueWithWait_Notify<Mensaje> queue = new CustomBlockingQueueWithWait_Notify<>();

        Runnable productor = () -> {
            for(int i = 0; i < 10 ; i++){
                Mensaje mensaje = new Mensaje("Mensaje-" + i);
                try {
                    queue.put(mensaje);
                    Thread.sleep(1000);
                    LOGGER.info("[Producer] Put : "+ mensaje.getMensaje());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            //adding exit message
            Mensaje mensaje = new Mensaje("exit");
            try {
                queue.put(mensaje);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable consumidor = () -> {
            try {
                Mensaje mensaje;
                while (!((mensaje = queue.take()).getMensaje().equals("exit"))){
                    Thread.sleep(2000);
                    LOGGER.info("[Consumer] Take : "+ mensaje.getMensaje());
                }
            }catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        //starting producer to produce messages in queue
        new Thread(productor).start();
        //starting consumer to consume messages from queue
        new Thread(consumidor).start();
    }
}
