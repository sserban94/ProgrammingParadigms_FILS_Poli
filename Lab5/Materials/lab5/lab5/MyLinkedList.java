package lab5;

import java.util.Collection;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> {
    private Node<T> first;

    public void add(T val) {
        // TODO implement add
    }

    public T get(int index) {
        // TODO implement get
        return null;
    }

    public T remove() {
        // TODO implement remove
        return null;

    }

    private static class Node<T> {
        Node<T> next;
        T value;

        public Node(T value) {
            this.value = value;
        }
    }
}
