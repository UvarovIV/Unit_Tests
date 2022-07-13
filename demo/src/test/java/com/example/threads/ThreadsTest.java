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

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Побочный поток");
        });

        thread.start();
        thread.join();
        System.out.println("Главный поток завершён");
    }

    @Test
    public void testThreads3() throws InterruptedException {

        Thread additionalThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("ddd");
            }
        });

        additionalThread.setDaemon(true);
        additionalThread.start();
        Thread.sleep(2100);
        System.out.println("WWW");
    }

    @Test
    public void testThreads4() {

        Store store = new Store();

        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);

        new Thread(producer).start();
        new Thread(consumer).start();

    }

    private void lambdaBody(Object lock) throws InterruptedException {
        Thread.sleep(5000);
        synchronized (lock) {
            System.out.println("Цикл выполнился");
            lock.notify();
        }
    }

    @Test
    public void testThreads5() throws InterruptedException {
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
        synchronized(lock) {
            lock.wait();
        }
    }

    @Test
    public void testThreads6() throws InterruptedException {
        
        Thread additionalThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(999);
                    System.out.println("Hello");
                } catch (InterruptedException e) {
                    System.out.println();
                }
            }
        });
         
        additionalThread.start();
        Thread.sleep(5000);   
        additionalThread.interrupt();
        System.out.println("Главный поток завершён");
    }
}
