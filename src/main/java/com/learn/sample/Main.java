package com.learn.sample;

import com.learn.library.Consumer;
import com.learn.library.Data;
import com.learn.library.Producer;

import java.util.concurrent.CompletableFuture;

/**
 * Created by pavan.vijayanar on 9/2/2016.
 */
public class Main {

    public static void main(String args[]) {
        Data data = new Data();
        Producer producer = new Producer(data);
        Consumer consumer = new Consumer(data);

        producer.start();
        consumer.start();
        //CompletableFuture.allOf(CompletableFuture.runAsync()).th

        System.out.println("Namaskara!!");
    }
}
