package com.serbanscorteanu.pp.lab6.problemset1.maps;

public class MapDemo {
    public static void main(String[] args) {
        MapImpl<Integer, String> mapImpl = new MapImpl<>();
        mapImpl.add(1, "Serban");
        mapImpl.add(2, "SerbanS");
        mapImpl.add(3, "SerbanSc");
        System.out.println("Map size: " + mapImpl.size());
        System.out.println("Map is empty? - " + mapImpl.isEmpty());
        System.out.println("Map contains the following keys: " + mapImpl.keys());
        System.out.println("Map contains the following entries: ");
        mapImpl.print();
        System.out.println("Deleting the second element: " + mapImpl.remove(2));
        mapImpl.print();

        // Demonstrate deep copy
        mapImpl.keys().set(1, 5);
        // the key should be the original one
        mapImpl.print();
    }
}
