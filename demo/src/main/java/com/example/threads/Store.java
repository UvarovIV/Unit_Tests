package com.example.threads;

public class Store {

    private volatile int products = 0;

    public synchronized void get() {

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

    public synchronized void add() {

        if (products > 15)
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
