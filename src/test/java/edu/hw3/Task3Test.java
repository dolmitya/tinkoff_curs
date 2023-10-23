package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class Task3Test {

    @Test
    @DisplayName("Слова по 2 раза")
    void freqDictStrTo2() {
        List<String> list = Arrays.asList("a", "bb", "a", "bb");
        String actual = Task3.freqDict(list).toString();
        String expected = "{\"bb\"=2, \"a\"=2}";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Слова по несколько раз")
    void freqDictStr() {
        List<String> list = Arrays.asList("this", "and", "that", "and");
        String actual = Task3.freqDict(list).toString();
        String expected = "{\"and\"=2, \"that\"=1, \"this\"=1}";
        assertEquals(expected, actual);
    }
}
