package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task1Test {
    @Test
    @DisplayName("Буква в строке")
    void wrongTime() {
        int actual = Task1.minutToSeconds("1e:10");
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Правильное время")
    void minutToSeconds1() {
        int actual = Task1.minutToSeconds("10:10");
        int expected = 610;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Время без минут")
    void firstDvoet() {
        int actual = Task1.minutToSeconds(":1046");
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Большое время")
    void minutToSeconds2() {
        int actual = Task1.minutToSeconds("50:46");
        int expected = 3046;
        assertEquals(expected, actual);
    }

}
