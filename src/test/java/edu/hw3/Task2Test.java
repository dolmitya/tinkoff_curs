package edu.hw3;

import edu.hw3.task2.Task2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    @Test
    @DisplayName("Поверка неправильной строки")
    void clusterizeyFalse() {
        List<String> actual = Task2.clusterize("af()");
        List<String> expected = null;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Поверка правильных скобок")
    void clusterizeyTrue() {
        String actual = Task2.clusterize("((()))(())()()(()())").toString();
        String expected = "[\"((()))\", \"(())\", \"()\", \"()\", \"(()())\"]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Поверка несбалансированных строк")
    void clusterizeyNotBalance() {
        List<String> actual = Task2.clusterize("((()))(())()()())");
        List<String> expected = null;
        assertEquals(expected, actual);
    }
}
