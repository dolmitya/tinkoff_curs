package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    @Test
    void countDigits() {
        int actual = Task2.countDigits(3786);
        int expected = 4;
        assertEquals(expected, actual);
        actual = Task2.countDigits(-54);
        expected = 2;
        assertEquals(expected, actual);
        actual = Task2.countDigits(3894769);
        expected = 7;
        assertEquals(expected, actual);
    }
}
