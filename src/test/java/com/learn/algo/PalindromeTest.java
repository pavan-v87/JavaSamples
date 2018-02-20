package com.learn.algo;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Pavan.VijayaNar on 10/9/2017.
 */
public class PalindromeTest {

    @Test
    public void testStringPalindrome() {
        assertFalse(Palindrome.isPalindrome("mani"));
        assertTrue(Palindrome.isPalindrome("pavap"));
        assertTrue(Palindrome.isPalindrome("kayak"));
        assertTrue(Palindrome.isPalindrome("bob"));
        assertTrue(Palindrome.isPalindrome("malayalam"));
        assertTrue(Palindrome.isPalindrome("wasitacatisaw"));
    }

    @Test
    public void testNumberReverse() {
        assertEquals(321, Palindrome.reverseNumber(123));
        assertEquals(5421, Palindrome.reverseNumber(1245));
        assertEquals(11225533, Palindrome.reverseNumber(33552211));
    }
}