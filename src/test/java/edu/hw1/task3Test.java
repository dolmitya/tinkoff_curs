package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class task3Test {
    @Test
    void isNestable() {
        int a1[] = {1, 2, 3, 4};
        int a2[] = {0, 6};
        boolean actual = task3.isNestable(a1, a2);
        boolean expected = true;
        assertEquals(expected, actual);
    }
}
