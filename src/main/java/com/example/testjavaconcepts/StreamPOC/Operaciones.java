package com.example.testjavaconcepts.StreamPOC;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Operaciones {

    public static void main(String[] args) {
        List<Persona> list = new ArrayList();
        list.add(new Persona("Esteban", "Briceo"));
        list.add(new Persona("Esteban", "Briceo"));
        list.add(new Persona("Andres", "Sati"));
//        List<List<Persona>> listOfList = new ArrayList();
//        listOfList.add(list);
//        listOfList.add(list);

            System.out.println(reducePOC());

    }

     /**************************
     *  Operaciones intermedias: IMPORTANTE-> Son LAZY (se ejecutaran si y solo si es alcanzada una operacion terminal)
     ***************************
     */

        // map()
        public static Stream<String> mapPOC(List<Persona> list){
            Stream<Persona> stream1 = list.stream();
            Stream<String> stream2 = stream1.map(persona -> persona.getNombre());
            return stream2;
        }

        // filter()
        public static Stream<Persona> filterPOC(List<Persona> list){
            Stream<Persona> stream1 = list.stream();
            Stream<Persona> stream2 = stream1.filter(persona-> "Esteban".equals(persona.getNombre()));
            return stream2;
        }

        //flatMap()
        public static Stream<Persona> flatMapPOC(List<List<Persona>> listofList){
            Stream<List<Persona>> stream1 = listofList.stream();
            Stream<Persona> stream2 = stream1.flatMap((list)-> list.stream()); // Collecion::stream
            return stream2;
        }

        //distinct()
        public static Stream<Persona> distinctPOC(List<Persona> list){
            Stream<Persona> stream1 = list.stream();
            Stream<Persona> stream2 = stream1.distinct();
            return stream2;
        }

        //sorted()
        public static Stream<Persona> sortedPOC(List<Persona> list){
            Stream<Persona> stream1 = list.stream();
            Stream<Persona> stream2 = stream1.sorted(Comparator.comparing(Persona::getNombre));
            return stream2;
        }

        //sorted()
        public static Stream<Integer> sortedPOC(){
            Stream<Integer> stream1 = Stream.of(6,4,2);
            Stream<Integer> stream2 = stream1.sorted();
            return stream2;
        }

        //peek()
        public static Stream<Persona> peekPOC(List<Persona> list){
            Stream<Persona> stream1 = list.stream();
            Consumer<Persona> consumer = x -> System.out.println(x);
            Stream<Persona> stream2 = stream1.peek(consumer); // System.out::println
            return stream2;
        }

        //limit()
        public static Stream<String> limitPOC(){
            Stream<String> stream1 = Stream.of("A","B","C");
            Stream<String> stream2 = stream1.limit(2);
            return stream2;
        }

        //skip()
        public static Stream<String> skipPOC(){
            Stream<String> stream1 = Stream.of("A","B","C");
            Stream<String> stream2 = stream1.skip(2);
            return stream2;
        }

     /*************************
     *  Operaciones terminales:
     **************************
     /

        /**
         *
         * retornan: void
         */

        // forEach | void forEach(Consumer<? super T> action);
        public static void forEachPOC(){
            Stream<String> stream1 = Stream.of("A","B","C");
            Consumer<String> consumer = x -> System.out.println(x);
            stream1.forEach(consumer);
        }

        //forEachOrdered() | void forEachOrdered(Consumer<? super T> action);
        public static void forEachOrderedPOC(){
            Stream<String> stream1 = Stream.of("C","D","A");
            Consumer<String> consumer = x -> System.out.println(x);
            stream1.forEachOrdered(consumer);
        }

        /**
         *
         * retorna: Object[]
         */

        //toArray() | Object[] toArray();
        public static Object[] toArrayPOC(){
            Stream<Integer> stream1 = Stream.of(22,11,44);
            Object[] arr = stream1.toArray();
            return arr;
        }

        /**
         *  retorna: List<T>
         */
        //collect() | <R, A> R collect(Collector<? super T, A, R> collector);
        public static List<Integer> collectPOC(){
            Stream<Integer> stream1 = Stream.of(22,11,44);
            List<Integer> list = stream1.collect(Collectors.toList());
            return list;
        }

        /**
         *
         * retornan: Optional<T>
         */

        //reduce() | Optional<T> reduce(BinaryOperator<T> accumulator);
        public static Optional<Integer> reducePOC(){
            Stream<Integer> stream1 = Stream.of(22,11,44);
            Optional<Integer> optional = stream1.reduce((op1, op2)-> op1 + op2);
            return optional;
        }

        //min() | Optional<T> min(Comparator<? super T> comparator);
        public static Optional<Integer> minPOC(){
            Stream<Integer> stream1 = Stream.of(22,11,44);
            Optional<Integer> max = stream1.min(Comparator.naturalOrder());
            return max;
        }

        //max() | Optional<T> max(Comparator<? super T> comparator);
        public static Integer maxPOC(){
            Stream<Integer> stream1 = Stream.of(22,11,44);
            Optional<Integer> max = stream1.max(Comparator.naturalOrder());
            return max.get();
        }

        //findFirst() | Optional<T> findFirst();
        public static Optional<String> findFirstPOC(){
            Stream<String> stream1 = Stream.of("C","D","A");
            Optional<String> primero = stream1.findFirst();
            return primero;
        }

        //findAny() | Optional<T> findAny();
        public static Optional<String> findAnyPOC(){
            Stream<String> stream1 = Stream.of("C","D","A");
            Optional<String> primero = stream1.findAny();
            return primero;
        }

        /**
         *
         * retorna: long
         */

        //count() | long count();
        public static long countPOC(){
            Stream<String> stream1 = Stream.of("C","D","A");
            long cantidad = stream1.count();
            return cantidad;
        }

        /**
          * retornan: boolean
         */

        //anyMatch() | boolean anyMatch(Predicate<? super T> predicate);
        public static boolean anyMatchPOC(){
            Stream<String> stream1 = Stream.of("C","D","A");
            boolean encontrado = stream1.anyMatch(x->"C".equals(x));
            return encontrado;
        }

        //allMatch() |  boolean allMatch(Predicate<? super T> predicate);
        public static boolean allMatchPOC(){
            Stream<String> stream1 = Stream.of("C","C","C");
            boolean encontrado = stream1.anyMatch(x->"C".equals(x));
            return encontrado;
        }

        //noneMatch() | boolean noneMatch(Predicate<? super T> predicate);
        public static boolean noneMatchPOC(){
            Stream<String> stream1 = Stream.of("A","A","A");
            boolean encontrado = stream1.noneMatch(x->"C".equals(x));
            return encontrado;
        }
}
