package edu.hw3;

import edu.hw3.task4.Task4;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task4Test {

    @Test
    @DisplayName("1628")
    void convertToRoman1628() {
        String actual = Task4.convertToRoman(1628);
        String expected = "MDCXXVIII";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("0")
    void convertToRoman0() {
        String actual = Task4.convertToRoman(0);
        String expected = "N";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("4")
    void convertToRoman4() {
        String actual = Task4.convertToRoman(4);
        String expected = "IV";
        assertEquals(expected, actual);
    }
}
