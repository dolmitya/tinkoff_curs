package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task7Test {

    @Test
    @DisplayName("Сдвиг вправо на 1")
    void rotateRight1() {
        int actual = Task7.rotateRight(8, 1);
        int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Сдвиг вправо на 2")
    void rotateRight2() {
        int actual = Task7.rotateRight(17, 2);
        int expected = 12;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Сдвиг вправо отрицательного числа")
    void rotateRightMinusD() {
        int actual = Task7.rotateRight(-17, 2);
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Сдвиг вправо на отрицательное число")
    void rotateRightMinusK() {
        int actual = Task7.rotateRight(8, -1);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Сдвиг влево на 1")
    void rotateLeft1() {
        int actual = Task7.rotateLeft(16, 1);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Сдвиг влево на 2")
    void rotateLeft2() {
        int actual = Task7.rotateLeft(17, 2);
        int expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Сдвиг влево отрицательного число")
    void rotateLeftMinusD() {
        int actual = Task7.rotateLeft(-10, 3);
        int expected = -1;
        assertEquals(expected, actual);
    }
}
