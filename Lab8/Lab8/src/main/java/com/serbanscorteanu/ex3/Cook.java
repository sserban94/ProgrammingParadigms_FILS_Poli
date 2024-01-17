package com.serbanscorteanu.ex3;

import java.util.concurrent.atomic.AtomicInteger;

public class Cook extends Thread {
    protected Kitchen kitchen;
    // I would've normally used an UUID with a UUID generator
    public static final AtomicInteger idGenerator = new AtomicInteger();

    public Cook(Kitchen kitchen) {
        this.kitchen = kitchen;
    }

    @Override
    public void run() {

        try {
            while (true) {
                int pizzaId = idGenerator.incrementAndGet();
                int ingredients = (int) ((Math.random() * (7 - 3)) + 3);
                Pizza pizza = new Pizza(pizzaId, ingredients);
                kitchen.addPizza(pizza);
                System.out.println("Pizza " + pizza + " was removed");
                Thread.sleep(5 * ingredients * 2000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
