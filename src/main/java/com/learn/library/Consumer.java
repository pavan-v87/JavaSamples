package com.learn.library;

/**
 * Created by Pavan.VijayaNar on 9/2/2017.
 */

public class Consumer extends Thread {

    private final Data food;

    public Consumer (Data data) {
        food = data;
    }

    @Override
    public void run() {
        while (true) {
            /*try {
                System.out.println("Consumer sleep for 1 sec");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            System.out.println("Eating " + food.giveMeFood());
        }
    }
}