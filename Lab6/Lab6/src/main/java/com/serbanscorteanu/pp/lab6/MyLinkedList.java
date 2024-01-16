package com.serbanscorteanu.pp.lab6;

import java.util.NoSuchElementException;

public class MyLinkedList<T> {
    private Node<T> first;

    public void add(T val) {
        if (first == null) {
            first = new Node<T>(val);
            return;
        }
        Node<T> currentNode = first;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = new Node<T>(val);
    }

    public T get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> currentNode = first;
        // index starts from 1 in this case. iterate through the linked list from 1 to index
        for (int i = 1; i <= index; i++) {
            // if currentNode is null it means the index was higher than the no of nodes
            if (currentNode == null) {
                throw new IndexOutOfBoundsException();
            }
            currentNode = currentNode.next;
        }
        // if all good return the value
        return currentNode.value;
    }

    public T remove() {
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
        // all other cases
        Node<T> currentNode = first;
        // go to the second to last node
        while (currentNode.next.next != null) {
            currentNode = currentNode.next;
        }
        // get the value from the last node
        T value = currentNode.next.value;
        // remove the pointer - next - from the second to last node - therefore deleting the last node
        currentNode.next = null;
        return value;
    }

    private static class Node<T> {
        Node<T> next;
        T value;

        public Node(T value) {
            this.value = value;
        }
    }
}
