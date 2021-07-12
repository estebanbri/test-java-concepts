package com.example.testjavaconcepts.DataStructures.list;

public class MyLinkedList {

    Node head;

    public MyLinkedList() {
        head = new Node();
    }

    /* public methods */

    public void add(int value){
        this.addRecursive(head, value);
    }

    public void print(){
        printNodesRecursive(head.next);
    }

    /* privates methods */

    private void addRecursive(Node node, int value) {
        if (node.next == null) {
            node.next = new Node(value);
            return;
        }
        this.addRecursive(node.next, value);
    }

    private void printNodesRecursive(Node node) {
        if (node == null) return;
        node.print();
        this.printNodesRecursive(node.next);
    }
}

class Node {

    int value;
    Node next;

    Node(){}

    Node(int value){
        this.value = value;
    }

    public void print() {
        System.out.println(value);
    }
}