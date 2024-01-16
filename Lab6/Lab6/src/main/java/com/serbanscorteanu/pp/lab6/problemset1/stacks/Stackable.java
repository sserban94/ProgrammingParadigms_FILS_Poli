package com.serbanscorteanu.pp.lab6.problemset1.stacks;

import java.util.NoSuchElementException;

public interface Stackable<T> {
    public void push(T val);

    public T pop();

    public T peek();

    public void print();

    public boolean isEmpty();

}
