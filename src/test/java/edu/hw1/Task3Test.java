package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task3Test {
    @Test
    void isNestable() {
        int[] a1 = new int[] {1, 2, 3, 4};
        int[] a2 = new int[] {0, 6};
        boolean actual = Task3.isNestable(a1, a2);
        boolean expected = true;
        assertEquals(expected, actual);
        a1 = new int[] {6, 7, 9, 4};
        a2 = new int[] {0, 6};
        actual = Task3.isNestable(a1, a2);
        expected = false;
        assertEquals(expected, actual);
        a1 = new int[] {0, 0, 0, 0};
        a2 = new int[] {0, 6};
        actual = Task3.isNestable(a1, a2);
        expected = false;
        assertEquals(expected, actual);
        a1 = new int[] {1, 0, 6};
        a2 = new int[] {};
        actual = Task3.isNestable(a1, a2);
        expected = false;
        assertEquals(expected, actual);
    }
}
