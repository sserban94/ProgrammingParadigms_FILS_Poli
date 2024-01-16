package com.serbanscorteanu.pp.lab6.problemset2;

import java.util.Objects;

public class Attraction {
    String name;
    String location;

    public Attraction(String name, String location) {
        this.name = name;
        this.location = location;
    }

    // need equals and hashCode for the map key (unique)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attraction that = (Attraction) o;
        return Objects.equals(name, that.name) && Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }

    @Override
    public String toString() {
        return "Attraction{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
