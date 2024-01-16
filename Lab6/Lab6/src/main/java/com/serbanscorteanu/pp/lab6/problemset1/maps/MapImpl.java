package com.serbanscorteanu.pp.lab6.problemset1.maps;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class MapImpl<K, V> implements Map<K, V> {
    final private LinkedList<K> keys;
    final private LinkedList<V> values;

    public MapImpl() {
        this.keys = new LinkedList<>();
        this.values = new LinkedList<>();
    }

    @Override
    public void add(K key, V value) {
        if (this.keys.contains(key)) {
            return;
        }
        this.keys.add(key);
        values.add(value);
    }

    @Override
    public V remove(K key) {
        // check if key exists
        if (!this.keys.contains(key)) {
            throw new NoSuchElementException();
        }
        // key exists now check index
        int keyIndex = this.keys.indexOf(key);
        if (keyIndex == -1) {
            throw new NoSuchElementException();
        }
        // all good in the hood
        this.keys.remove(keyIndex);
        return this.values.remove(keyIndex);
    }

    @Override
    public int size() {
        // no point in checking for null in either of these as I instantiate them in the ctor
        return this.keys.size();
    }

    @Override
    public boolean isEmpty() {
        // also keys = values when it comes to size
        return this.keys.isEmpty();
    }

    @Override
    public List<K> keys() {
        // If I send this.keys someone could modify the keys
        //        for (K element : this.keys) {
//            linkedListClone.add(element);
//        }
        // or
        return new LinkedList<>(this.keys);
    }

    @Override
    public void print() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.keys.size(); i++) {
            stringBuilder.append("K: ");
            stringBuilder.append(this.keys.get(i));
            stringBuilder.append(" V: ");
            stringBuilder.append(this.values.get(i));
            stringBuilder.append(System.lineSeparator());
        }
        System.out.println(stringBuilder);
    }
}
