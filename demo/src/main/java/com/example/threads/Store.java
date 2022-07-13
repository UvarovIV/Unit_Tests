package com.example.threads;

public class Store {

    private volatile int products = 0;

    public synchronized void get() {
        for (int i = 0; i < 10; i++) {
            if (products < 1)
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            products--;
            System.out.println(products);
            notify();
        }
    }

    public synchronized void add() {
        for (int i = 0; i < 10; i++) {
            if (products > 5)
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            products++;
            System.out.println(products);
            notify();
        }
    }
}
