package com.example.threads;

import org.junit.Test;

public class ThreadsTest {

    @Test
    public void testThreads1() {
        Thread thread = new PrintNameThread("Thread");
        Thread runnable = new Thread(new PrintNameRunnable("Runnable"));
        thread.start();
        runnable.start();
    }

    @Test
    public void testThreads2() throws InterruptedException {

        Thread firstThread = new Thread(() -> {
            for (int i = 0; i < 15; i++)
                System.out.println(i);
        });

        Thread secondThread = new Thread(() -> {
            for (int i = 0; i < 15; i++)
                System.out.println("Hello");
        });

        secondThread.start();
        secondThread.join();
        firstThread.start();
    }

    @Test
    public void testThreads3() {

        Thread additionalThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted())
                System.out.println("additional");
        });

        Thread mainThread = new Thread(() -> {
            for (int i = 0; i < 15; i++)
                System.out.println("main");
            additionalThread.interrupt();
        });

        additionalThread.start();
        mainThread.start();
    }

    @Test
    public void testThreads4() {

        Store store = new Store();

        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);

        new Thread(producer).start();
        new Thread(consumer).start();
        
    }

    private void checkTime(Object lock, long startTime) throws InterruptedException {
        long currentTime = System.currentTimeMillis() - startTime;
        if (currentTime >= 5000)
            lock.wait();
    }

    private void lambdaBody(Object lock) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        synchronized (lock) {
            while (true){
                checkTime(lock, startTime);
                System.out.println("Цикл выполнился");
            }    
        }
    }

    @Test
    public void testThreads5() {
        Object lock = new Object();
        Thread thread = new Thread(() -> {
            try {
                lambdaBody(lock);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.setDaemon(true);
        thread.start();
    }


    @Test
    public void testThreads6() throws InterruptedException {
        Object lock = new Object();
        Thread thread = new Thread(() -> {
            synchronized (lock) {
                while (true)
                    System.out.println("Цикл сработал");
            }
        });
        thread.start();
        synchronized (lock) {
            long startTime = System.currentTimeMillis();
            checkTime(lock, startTime);
        }
    }
}
