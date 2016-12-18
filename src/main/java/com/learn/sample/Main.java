package com.learn.sample;

import com.learn.sample.thread.MyThread;

/**
 * Created by pavan.vijayanar on 9/2/2016.
 */
public class Main {

    public static void main(String args[]) {
        System.out.println("Namaskara!!");
        new MyThread().start();
    }
}
