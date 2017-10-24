package com.learn.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Pavan.VijayaNar on 9/2/2017.
 */

public class Data {
    private Stack<String> food = new Stack<>();
    CountDownLatch countDownLatch = new CountDownLatch(1);
    Semaphore semaphore = new Semaphore(2);
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    Semaphore readSemaphore = new Semaphore(1);
    Semaphore writeSemaphore = new Semaphore(1);

    CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

   /* Lock minAvailabilityLock = new ReentrantLock();
    Lock accessLock = new ReentrantLock();*/

    private Object minAvailabilityLock = new Object();
    final Object accessLock = new Object();

    private final Lock readLock = readWriteLock.readLock();
    private final Lock writeLock = readWriteLock.writeLock();

    public String giveMeFood() {
        while (food.isEmpty()) {
            synchronized (minAvailabilityLock) {
                try {
                    minAvailabilityLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        String pop;
        synchronized (accessLock) {
            pop = food.pop();
        }
        return pop;
    }

    public void addFood(String item) {
        synchronized (accessLock) {
            food.push(item);
        }
        synchronized (minAvailabilityLock) {
            minAvailabilityLock.notify();
        }
    }

    /*public String giveMeFood() {
       while (food.size() < 2) {
           minAvailabilityLock.lock();
       }

        String pop = food.pop();
        accessLock.unlock();
        return pop;
    }

    public void addFood(String item) {
        accessLock.lock();
        food.push(item);
        accessLock.unlock();
        minAvailabilityLock.unlock();
    }*/

    /*public String giveMeFood() {
        try {
            cyclicBarrier.await();
        } catch (BrokenBarrierException | InterruptedException e) {
            e.printStackTrace();
        }
        String pop = food.pop();
        cyclicBarrier.reset();
        return pop;
    }*/

    /*public String giveMeFood() {
        while(food.size() < 2) {
            try {
                readSemaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String pop = food.pop();
        return pop;
    }*/

    /*public void addFood(String item) {
        food.push(item);
        cyclicBarrier.
    }*/

    /*public void addFood(String item) {
        food.push(item);
        readSemaphore.release();
    }*/
}
