package com.example.testjavaconcepts.CollectionsJava;

import java.util.*;

public class CollectionsPOC {
    public static void main(String[] args) {

        List<String> nombres = new ArrayList<>();
        nombres.add("A");
        nombres.add("E");
        nombres.add("X");
        nombres.add("Z");
        nombres.add("Y");

        // Swap
        Collections.swap(nombres, 0, 2);

        System.out.println("Swap: " + nombres);

        // Reverse
        Collections.reverse(nombres);

        System.out.println("Reverse: " + nombres);

        //  Sort in natural order:  must implement the Comparable interface
        Collections.sort(nombres);

        System.out.println("Sort(natural order): " + nombres);

        //  Sort in natural order:  must implement the Comparable interface
        Collections.sort(nombres, Comparator.comparing(Object::toString).reversed());

        System.out.println("Sort(alternative order): " + nombres);

        // Max
        System.out.println("Max: " + Collections.max(nombres));

        List<String> nombresTarget = new ArrayList<>();
        nombresTarget.add("THIS-WILL-BE-REPLACED");
        nombresTarget.add("THIS-WILL-BE-REPLACED");
        nombresTarget.add("THIS-WILL-BE-REPLACED");
        nombresTarget.add("THIS-WILL-BE-REPLACED");
        nombresTarget.add("THIS-WILL-BE-REPLACED");

        // Disjoint
        boolean noElementsInCommon = Collections.disjoint(nombresTarget, nombres);
        System.out.println("Disjoint:" + noElementsInCommon);

        // Copy
        Collections.copy(nombresTarget, nombres);
        System.out.println("Copy: " + nombresTarget);

        // BinarySearch
        Collections.sort(nombres);// must be sorted before calling bynarySearch
        int index = Collections.binarySearch(nombres, "E");
        System.out.println("BinarySearch: " + index);

    }


}
