package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task7Test {

    @Test
    void rotateRight1() {
        int actual = Task7.rotateRight(8, 1);
        int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    void rotateRight2() {
        int actual = Task7.rotateRight(17, 2);
        int expected = 12;
        assertEquals(expected, actual);
    }

    @Test
    void rotateRightMinusD() {
        int actual = Task7.rotateRight(-17, 2);
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    void rotateRightMinusK() {
        int actual = Task7.rotateRight(8, -1);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void rotateLeft1() {
        int actual = Task7.rotateLeft(16, 1);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void rotateLeft2() {
        int actual = Task7.rotateLeft(17, 2);
        int expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    void rotateLeftMinusD() {
        int actual = Task7.rotateLeft(-10, 3);
        int expected = -1;
        assertEquals(expected, actual);
    }
}
