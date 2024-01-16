package com.serbanscorteanu.pp.lab6.problemset1.stacks;

import java.util.NoSuchElementException;

public class MyStack<T> {
    private Node<T> first;


    public MyStack() {
    }


    public void push(T val) {
        if (first == null) {
            first = new Node<>(val);
            return;
        }
        Node<T> currentNode = first;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = new Node<>(val);
    }

    public T pop() {
//        TODO - test this - check corner cases - null, empty, one element, two and so on
        // if empty
        if (first == null) {
            throw new NoSuchElementException();
        }

        // if only one node
        if (first.next == null) {
            T value = first.value;
            first = null;
            return value;
        }

        // two pointer method - below is the single pointer one as well
        Node<T> currentSlowNode = first;
        Node<T> currentFastNode = first;
        while (currentFastNode.next != null) {
            currentSlowNode = currentSlowNode.next;
            currentFastNode = currentSlowNode.next;
        }
        T val = currentFastNode.value;
        currentSlowNode.next = null;
        return val;
    }

//    the method from the linked list class
//    public T remove() {
//        // if empty
//        if (first == null) {
//            throw new NoSuchElementException();
//        }
//        // if only one node
//        if (first.next == null) {
//            T value = first.value;
//            first = null;
//            return value;
//        }
//        // all other cases
//        Node<T> currentNode = first;
//        // go to the second to last node
//        while (currentNode.next.next != null) {
//            currentNode = currentNode.next;
//        }
//        // get the value from the last node
//        T value = currentNode.next.value;
//        // remove the pointer - next - from the second to last node - therefore deleting the last node
//        currentNode.next = null;
//        return value;
//}

    public T peek() {
//        TODO - test this - check corner cases
        if (first == null) {
            throw new NoSuchElementException();
        }
        Node<T> currentNode = first;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        return currentNode.value;
    }

//    reversed print
    public void print() {
        // recursion I guess - iterative way would need another ds such as an array

        Node<T> node = this.first;
        recursivePrint(node);
    }

    private void recursivePrint(Node<T> node) {
        // I always declare base case and recursive case - habit from coding bat exercises
        // base case
        if (node == null) {
            return;
        }

        // recursive case
        recursivePrint(node.next);
        System.out.println(node.value);
    }


    private static class Node<T> {
        Node<T> next;
        T value;

        public Node(T value) {
            this.value = value;
        }
    }
}
