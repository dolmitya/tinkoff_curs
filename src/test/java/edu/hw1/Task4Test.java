package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task4Test {

    @Test
    void fixString1() {
        String actual = Task4.fixString("123456");
        String expected = "214365";
        assertEquals(expected, actual);
    }

    @Test
    void fixString2() {
        String actual = Task4.fixString("hTsii  s aimex dpus rtni.g");
        String expected = "This is a mixed up string.";
        assertEquals(expected, actual);
    }

    @Test
    void fixString3() {
        String actual = Task4.fixString("badce");
        String expected = "abcde";
        assertEquals(expected, actual);
    }
}
