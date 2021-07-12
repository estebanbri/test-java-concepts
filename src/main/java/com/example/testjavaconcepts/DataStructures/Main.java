package com.example.testjavaconcepts.DataStructures;

import com.example.testjavaconcepts.DataStructures.list.MyLinkedList;
import com.example.testjavaconcepts.DataStructures.tree.MyTree;

public class Main {
    public static void main(String[] args) {

        // MyLinkedList

        MyLinkedList list = new MyLinkedList();

        list.add(2);
        list.add(1);
        list.add(3);

        list.print();

        // MyTree

        MyTree tree = new MyTree();
        tree.add(5);
        tree.add(2);
        tree.add(9);

        tree.print();
    }
}
