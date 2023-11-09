package edu.hw3;

import edu.hw3.task1.Task1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task1Test {

    @Test
    @DisplayName("Поверка пустой строки")
    void atbachEmpty() {
        String actual = Task1.atbash("");
        String expected = "";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Поверка строки")
    void atbachString() {
        String actual = Task1.atbash("jaghsfkGFJAH");
        String expected = "qztshupTUQZS";
        assertEquals(expected, actual);
    }
}
