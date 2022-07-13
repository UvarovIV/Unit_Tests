package com.example.threads;

public class PrintNameThread extends Thread {

    private String name;

    PrintNameThread() {}

    public PrintNameThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name);
    }

}