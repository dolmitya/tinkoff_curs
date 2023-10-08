package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task6Test {

    @Test
    void countK() {
        int actual = Task6.countK(3524);
        int expected = 3;
        assertEquals(expected, actual);
        actual = Task6.countK(1000);
        expected = 5;
        assertEquals(expected, actual);
        actual = Task6.countK(1234);
        expected = 3;
        assertEquals(expected, actual);
    }
}
