package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task1Test {
    @Test
    void minutToSeconds() {
        int actual = Task1.minutToSeconds("1e:10");
        int expected = -1;
        assertEquals(expected, actual);
        actual = Task1.minutToSeconds("10:10");
        expected = 610;
        assertEquals(expected, actual);
        actual = Task1.minutToSeconds(":1046");
        expected = -1;
        assertEquals(expected, actual);
        actual = Task1.minutToSeconds("50:46");
        expected = 3046;
        assertEquals(expected, actual);
    }
}
