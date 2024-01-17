package com.serbanscorteanu.ex3;

import java.util.LinkedList;
import java.util.Queue;

public class Kitchen {
    private final Queue<Pizza> pizzaQueue;
    private final int capacity = 10;

    public Kitchen() {
        this.pizzaQueue = new LinkedList<>();
    }

    public synchronized void addPizza(Pizza pizza) throws InterruptedException {
        while (pizzaQueue.size() == capacity) {
            wait();
        }
        pizzaQueue.add(pizza);
        System.out.println("Pizza no " + pizza.getId() + " was added");
        notifyAll();
    }

    public synchronized Pizza removePizza() throws InterruptedException {
        while (pizzaQueue.isEmpty()) {
            wait();
        }
        Pizza pizza = pizzaQueue.poll();
        System.out.println("Pizza nr " + pizza.getId() + " was removed");
        notifyAll();
        return pizza;
    }
}
