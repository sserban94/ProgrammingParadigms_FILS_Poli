package com.serbanscorteanu.pp.practice;

public class Node {
    int key;
    String name;

    Node leftChild;
    Node rightChild;

    Node(int key, String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name + " has the key " + this.key;
    }
}
