package com.example.threads;

public class PrintNameRunnable implements Runnable {

    private String name;

    PrintNameRunnable() {}

    public PrintNameRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name);
    }

}
