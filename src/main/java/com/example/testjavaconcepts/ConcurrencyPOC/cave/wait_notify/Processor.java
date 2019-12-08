package com.example.testjavaconcepts.ConcurrencyPOC.cave.wait_notify;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Processor {
    Logger LOG = LoggerFactory.getLogger(Processor.class);

    public void m1() throws InterruptedException {
        synchronized (this){  // MISMO OBJETO DE LOCK TANTO EL PRODUCER COMO PRODUCER PARA QUE FUNCIONE EL PATRON WAIT-NOTIFY
            LOG.info("m1() -  Thread running...");
            // Cuando llegue al metodo wait va a hacer suspender la ejecucion del thread actual y va a liberar el lock. Por ende el otro thread va a ejecutar el segundo metodo es decir el metodo consume() ya que al haber liberado el lock el otro thread va a tomar el control del lock y va a ejecutar el codigo del metodo consume()
            this.wait(); // duerme hasta que desde otro thread que use el mismo objeto de lock avise con notify() (esto es importante para que funcione el codigo que hace notify tienen que trabajar sobre el mismo objeto de lock en este caso sobre this es decir un lock intrinseco de la clase)
            LOG.info("m1() -  Thread corriendo nuevamente, i have re-gained control of this lock...");
        }
    }

    public void m2() throws InterruptedException {
        Thread.sleep(2000); // Lo dormimos 2 segundos para que asegurarnos de que el thread corriendo produce() produzca el valor
        synchronized (this){  // MISMO OBJETO DE LOCK TANTO EL PRODUCER COMO PRODUCER PARA QUE FUNCIONE EL PATRON WAIT-NOTIFY
            LOG.info("m2() -  Thread running...");
            this.notify(); // va a notificar al thread que se encuentre esperando (es decir que haya sido frenado con un lock.wait()) por ganar el control del lock para retomar su ejecucion.
            Thread.sleep(5000); // Esta linea es para demostrar que this.notify() no hace que en ese mismo instante se libere el lock sino tiene que terminar de ejecutarse todo este bloque synchonized para que recien se libere el lock y el otro thread pueda tomar el control del lock
        }
    }

}
