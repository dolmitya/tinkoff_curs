package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    @Test
    @DisplayName("Положительное число")
    void countDigits() {
        int actual = Task2.countDigits(3786);
        int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Отрицательное число")
    void countMinusDigits() {
        int actual = Task2.countDigits(-54);
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Большое число")
    void MuchCountDigits() {
        int actual = Task2.countDigits(3894769);
        int expected = 7;
        assertEquals(expected, actual);
    }
}
