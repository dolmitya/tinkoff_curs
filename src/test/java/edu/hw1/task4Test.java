package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class task4Test {

    @Test
    void fixString() {
        String actual=task4.fixString("123456");
        String expected = "214365";
        assertEquals(expected,actual);
        actual=task4.fixString("hTsii  s aimex dpus rtni.g");
        expected = "This is a mixed up string.";
        assertEquals(expected,actual);
        actual=task4.fixString("badce");
        expected = "abcde";
        assertEquals(expected,actual);
    }
}
