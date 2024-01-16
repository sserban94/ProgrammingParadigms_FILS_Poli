package com.serbanscorteanu.pp.lab6.problemset1.maps;

import java.util.List;

public interface Map <K,V> {
    public void add(K key, V value);
    public V remove(K key);
    public int size();
    public boolean isEmpty();
    public List<K> keys();
    public void print();
}
