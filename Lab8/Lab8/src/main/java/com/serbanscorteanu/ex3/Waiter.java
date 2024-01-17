package com.serbanscorteanu.ex3;

public class Waiter extends Thread {
    protected Kitchen kitchen;

    public Waiter(Kitchen kitchen) {
        this.kitchen = kitchen;
    }

    @Override
    public void run() {

        try {
            while (true) {
                Pizza pizza = kitchen.removePizza();
                if (pizza != null) {
                    System.out.println("Pizza " + pizza + " was removed");
                    Thread.sleep(10000);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
            ;
        }
    }
}
