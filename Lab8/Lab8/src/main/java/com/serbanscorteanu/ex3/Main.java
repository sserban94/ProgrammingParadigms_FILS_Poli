package com.serbanscorteanu.ex3;

public class Main {
    public static void main(String[] args) {
        Kitchen kitchen = new Kitchen();

        // Start 3 cooks
        for (int i = 0; i < 3; i++) {
            new Thread(new Cook(kitchen)).start();
        }

        // Start 4 waiters
        for (int i = 0; i < 4; i++) {
            new Thread(new Waiter(kitchen)).start();
        }
    }
}
