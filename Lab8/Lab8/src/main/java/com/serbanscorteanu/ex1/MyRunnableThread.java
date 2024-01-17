package com.serbanscorteanu.ex1;

import java.time.LocalDateTime;

import static java.lang.Thread.sleep;

public class MyRunnableThread implements Runnable{
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
