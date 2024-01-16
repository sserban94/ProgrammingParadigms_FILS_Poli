package com.serbanscorteanu.pp.lab6.problemset2;

import java.util.List;

public class TouristPackage {
    String name;
    int id;
    double price;
    List<Attraction> attractions;

    public TouristPackage(String name, int id, double price, List<Attraction> attractions) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.attractions = attractions;
    }
}
