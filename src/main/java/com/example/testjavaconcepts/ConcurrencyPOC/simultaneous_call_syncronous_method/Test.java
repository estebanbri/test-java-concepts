package com.example.testjavaconcepts.ConcurrencyPOC.simultaneous_call_syncronous_method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {
    public static void main(String[] args) {
        /**
         * EN RESUMEN DE LO DE ABAJO: el Planificador de Thread (Thread Scheduler) del SO determina orden de ejecucion
         * T0.start() -> Runnable -> cuando llega a synchronized -> Adquiere lock y ejecuta bloque synchronized
         * T1.start() -> Runnable -> cuando llega a synchronized -> No adquiere lock por ende no ejecuta bloque sync y pasa a estado "BLOCKED"
         * Una vez que T0 termina con el bloque syncrhonzied libera el lock y el mismo Planificador es el que va a volver al estado "Runnable"
         * a T1 que el mismo planificador lo habia cambiado a estado "BLOCKED" al intentar ejecutar una seccion de codigo syncrhonized
         * que aun estaba siendo utilizada por otro thread T0 que aun no habia liberado el lock.
         */




        // Ejemplo: cuando se ejecuta start() no comienza automaticamente, sino
        // lo que sucede es que el nuevo Thread-0 pasa a estado "Runnable" entonces el
        // CPU va a ejecutar concurrentemente el nuevo Thread Thread-0 con el Thread-main.
        // Cuando el nuevo Thread llega al bloque synchronized obtiene el lock y hasta que
        // no termine de ejecutar dicho bloque entero no libera el lock. En caso de que se
        // cree un nuevo Thread-1 y se llame a start(), este nuevo Thread-1 para a estado "Runnable"
        // y suponiendo que todavia no termino de ejecutar el bloque synchronized el Thread-1
        // es decir aun no libero el lock, cuando el Thread Scheduler del SO seleccione para ejecutar
        // este nuevo Thread-1 este Thread va a cambiar de estado a "BLOCKED"

        // Conclusion: es el que determina que thread va a ser el siguiente a ejecutar, NO ES POR ORDER DE EJECUCIóN
        // es decir el orden en que se vayan ejecutando los threads es totalmente dependiende del algoritmo
        // usado por el Thread Scheduler para seleccionar cual es el siguiente a ejecutar la seccion critica.
        // Es decir aunque se llame en orden al start() de cada thread asi como esta el codigo que
        // se hace en orden Thread-0.start(), Thread-2.start(),...,Thread-9.start(), la salida
        // el output que vas a recibir es totalmente aleatorio (segun en como vaya ejecutando el Planificador
        //  de Thread)
        A a = new A();
        for(int i = 0; i < 10; i++){
            Runnable r = new MyRunnable(a);
            new Thread(r,"T".concat(String.valueOf(i))).start();
        }
    }
    private static class MyRunnable implements Runnable {

        private A a;

        public MyRunnable(A a){
            this.a = a;
        }

        @Override
        public void run() {
            a.m1();
        }
    }

}
class A {
    private static final Logger log = LoggerFactory.getLogger(A.class);
    void m1(){
        synchronized (this){
            // SECCION CRITICA NO PUEDE SER ACCEDIDO POR MAS DE UN THREAD SIMULTANEAMENTE
            log.info(Thread.currentThread().getName());
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
