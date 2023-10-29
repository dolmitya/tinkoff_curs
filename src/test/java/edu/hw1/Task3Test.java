package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task3Test {
    @Test
    @DisplayName("Вложенные масиивы")
    void isNestableTrue() {
        int[] a1 = new int[] {1, 2, 3, 4};
        int[] a2 = new int[] {0, 6};
        boolean actual = Task3.isNestable(a1, a2);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Невложенные массивы")
    void isNestableFalse() {
        int[] a1 = new int[] {6, 7, 9, 4};
        int[] a2 = new int[] {0, 6};
        boolean actual = Task3.isNestable(a1, a2);
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Нулевой массив")
    void isNestableTrueNulls() {
        int[] a1 = new int[] {0, 0, 0, 0};
        int[] a2 = new int[] {0, 6};
        boolean actual = Task3.isNestable(a1, a2);
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Пустой масиив")
    void isNestableTrueClear() {
        int[] a1 = new int[] {1, 0, 6};
        int[] a2 = new int[] {};
        boolean actual = Task3.isNestable(a1, a2);
        boolean expected = false;
        assertEquals(expected, actual);
    }
}
