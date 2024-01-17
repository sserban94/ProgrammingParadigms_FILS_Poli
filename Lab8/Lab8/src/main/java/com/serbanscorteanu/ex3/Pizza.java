package com.serbanscorteanu.ex3;

public class Pizza {
    private int id;
    private int numberOfIngredients;

    public Pizza(int id, int numberOfIngredients) {
        this.id = id;
        this.numberOfIngredients = numberOfIngredients;
    }

    public int getId() {
        return id;
    }

    public int getNumberOfIngredients() {
        return numberOfIngredients;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", numberOfIngredients=" + numberOfIngredients +
                '}';
    }
}
