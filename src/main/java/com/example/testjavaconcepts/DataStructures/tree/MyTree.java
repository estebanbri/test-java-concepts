package com.example.testjavaconcepts.DataStructures.tree;

public class MyTree {

    Node root;

    public MyTree(){
        root = new Node();
    }

    /* public methods */

    public void add(int value){
        if(root.value == 0) root.value = value;
        addRecursive(root, value);
    }

    public void print(){
        printNodesRecursive(root);
    }

    /* privates methods */

    private void addRecursive(Node node, int value) {
        if(value > node.value) {
            if(node.right == null) {
                node.right = new Node(value);
                return;
            }
            this.addRecursive(node.right, value);
        }
        if(value < node.value) {
            if(node.left == null) {
                node.left = new Node(value);
                return;
            }
            this.addRecursive(node.left, value);
        }
    }

    private void printNodesRecursive(Node node) {
        if (node == null) return;
        node.print();
        this.printNodesRecursive(node.right);
        this.printNodesRecursive(node.left);
    }
}

class Node {

    int value;
    Node right;
    Node left;

    Node(){}

    Node(int value){
        this.value = value;
    }

    public void print() {
        System.out.println(value);
    }
}
