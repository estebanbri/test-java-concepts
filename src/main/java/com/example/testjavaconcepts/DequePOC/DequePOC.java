package com.example.testjavaconcepts.DequePOC;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequePOC {
    public static void main(String[] args) {

       m1();
       System.out.println("--------------");
       m2();

    }

    // Deque as a STACK
    public static void m1(){
        Deque<String> stack = new ArrayDeque<>();

        stack.push("first");
        stack.push("second");

        System.out.println("Stack: " + stack);

        String valor = stack.pop();
        System.out.println("Elemento quitado de cima:  " + valor);

        System.out.println("Cima: " + stack.peek());

        System.out.println("Stack: " + stack);
    }

    // Deque as a QUEUE
    public static void m2(){
        Deque<String> queue = new ArrayDeque<>();

        queue.offer("first");
        queue.offer("second");

        System.out.println("Queue: " + queue);

        String valor = queue.pop();
        System.out.println("Elemento quitado de cima:  " + valor);

        System.out.println("Cima: " + queue.peek());

        System.out.println("Stack: " + queue);
    }
}
