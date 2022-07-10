package com.example.threads;

public class Threads {
    public static void main(String[] args) throws InterruptedException {
       /*  Thread thread = new Thread (
            () -> {
                try {
                    Thread.sleep(4000);
                    System.out.println("Second");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
            }
        );

        thread.start();
        System.out.println("main"); */

        ThreadImpl threadImpl = new ThreadImpl();
        threadImpl.start();

        Thread.sleep(3000);

        threadImpl.interrupt();
    }
}

class ThreadImpl extends Thread {
    @Override
    public void run() {
        int i = 0;
        do {
            i++;
            System.out.println(i + "");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        } while (!Thread.interrupted());

        return;
    }

}
