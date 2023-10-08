package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class task5Test {

    @Test
    void isPalindromeDescendant() {
        boolean actual = task5.isPalindromeDescendant(11211230);
        boolean expected = true;
        assertEquals(expected, actual);
        actual = task5.isPalindromeDescendant(11211);
        expected = true;
        assertEquals(expected, actual);
        actual = task5.isPalindromeDescendant(211);
        expected = true;
        assertEquals(expected, actual);
        actual = task5.isPalindromeDescendant(21);
        expected = false;
        assertEquals(expected, actual);
    }
}
