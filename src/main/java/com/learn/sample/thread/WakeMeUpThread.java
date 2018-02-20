package com.learn.sample.thread;

import java.util.concurrent.Semaphore;

/**
 * Created by Pavan.VijayaNar on 5/27/2017.
 */

public class WakeMeUpThread extends Thread {

    @Override
    public void run() {
        while(true) {
            synchronized (this) {
                try {
                    System.out.println("I am Waiting..");
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("I got interrupted!!");
                    //e.printStackTrace();
                }
            }
        }
    }

    public synchronized void interruptMe() {
        interrupt();
    }

    public synchronized void notifyMe() {
        notify();
    }
}
