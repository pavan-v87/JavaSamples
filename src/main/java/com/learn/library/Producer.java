package com.learn.library;

import java.util.Random;

/**
 * Created by Pavan.VijayaNar on 9/2/2017.
 */

public class Producer extends Thread {

    private final Data food;
    private int index;
    Random random = new Random();

    public Producer (Data data) {
        food = data;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int time = random.nextInt(3) * 1000;
                System.out.println(String.format("Producer sleep for %d sec", time/1000));
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String item = "Item " + (++index);
            System.out.println("Producer Adding: " + item);
            food.addFood(item);
        }
    }
}
