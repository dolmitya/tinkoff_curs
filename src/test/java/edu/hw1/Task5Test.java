package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task5Test {

    @Test
    void isPalindromeDescendant1() {
        boolean actual = Task5.isPalindromeDescendant(11211230);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    void isPalindromeDescendantNechetPalindrom() {
        boolean actual = Task5.isPalindromeDescendant(11211);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    void isPalindromeDescendantNechetNePalind() {
        boolean actual = Task5.isPalindromeDescendant(211);
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    void isPalindromeDescendantLowDidgit() {
        boolean actual = Task5.isPalindromeDescendant(21);
        boolean expected = false;
        assertEquals(expected, actual);
    }
}
