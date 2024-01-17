package com.serbanscorteanu.ex1;

public class Main {
    public static void main(String[] args) {
//        MyThread myThread = new MyThread();
//        MyThread mySecondThread = new MyThread();
//        MyThread myThirdThread = new MyThread();
//        myThread.start();
//        mySecondThread.start();
//        myThirdThread.start();

        // Runnable
        MyRunnableThread myRunnableThread = new MyRunnableThread();
        MyRunnableThread mySecondRunnableThread = new MyRunnableThread();
        MyRunnableThread myThirdRunnableThread = new MyRunnableThread();
        Thread thread = new Thread(myRunnableThread);
        Thread secondThread = new Thread(mySecondRunnableThread);
        Thread thirdThread = new Thread(myThirdRunnableThread);
        thread.start();
        secondThread.start();
        thirdThread.start();
    }
}
