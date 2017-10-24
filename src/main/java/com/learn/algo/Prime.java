package com.learn.algo;

/**
 * Created by Pavan.VijayaNar on 10/9/2017.
 */

public class Prime {
    static boolean isPrime(int number) {
        if (number == 1 || number == 2) return true;

        if (number % 2 == 0) return false;

        double sqrt = Math.sqrt(number);
        int i = 3;
        while (i < sqrt) {
            if (number % i == 0) return false;
            i+=2;
        }
        return true;
    }
}
