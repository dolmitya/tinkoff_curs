package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    @Test
    @DisplayName("Поверка неправильной строки")
    void clusterizeyFalse() {
        String actual = Task2.clusterize("af()");
        String expected = "";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Поверка правильных скобок")
    void clusterizeyTrue() {
        String actual = Task2.clusterize("((()))(())()()(()())");
        String expected = "[\"((()))\", \"(())\", \"()\", \"()\", \"(()())\"]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Поверка несбалансированных строк")
    void clusterizeyNotBalance() {
        String actual = Task2.clusterize("((()))(())()()())");
        String expected = "";
        assertEquals(expected, actual);
    }
}
