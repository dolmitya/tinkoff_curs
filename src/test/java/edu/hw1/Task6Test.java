package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task6Test {

    @Test
    @DisplayName("Число с 3-мя проходами")
    void countK1() {
        int actual = Task6.countK(3524);
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Тысяча")
    void countK2() {
        int actual = Task6.countK(1000);
        int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("1234")
    void countK3() {
        int actual = Task6.countK(1234);
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Изначально Каприкара")
    void countKPostKapr() {
        int actual = Task6.countK(6174);
        int expected = 0;
        assertEquals(expected, actual);
    }
}
