package com.serbanscorteanu.ex1;

import java.time.LocalDateTime;

public class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                System.out.println(LocalDateTime.now());
                sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
