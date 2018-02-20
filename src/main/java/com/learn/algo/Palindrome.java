package com.learn.algo;

/**
 * Created by Pavan.VijayaNar on 10/9/2017.
 */

public class Palindrome {
    static boolean isPalindrome(String s) {
        char cs[] = s.toCharArray();
        int length = s.length();
        int mid = length /2;
        int i=1;
        while (i <= mid -1) {
            if (cs[mid + i] != cs[mid - i]) {
                return false;
            }
            i++;
        }
        return true;
    }

    static int reverseNumber(int number) {
        int reverse = 0;
        while (number > 0) {
            reverse = reverse*10 + number % 10;
            number=number/10;
        }
        return reverse;
    }
}
