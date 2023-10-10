package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task5Test {

    @Test
    @DisplayName("Правильный палиндром")
    void isPalindromeDescendant1() {
        boolean actual = Task5.isPalindromeDescendant(11211230);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Изначальные палиндром с нечетным кол-вом цифр")
    void isPalindromeDescendantNechetPalindrom() {
        boolean actual = Task5.isPalindromeDescendant(11211);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Не палиндром с нечетным количеством цифр")
    void isPalindromeDescendantNechetNePalind() {
        boolean actual = Task5.isPalindromeDescendant(211);
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Маленькое число не палиндром")
    void isPalindromeDescendantLowDidgit() {
        boolean actual = Task5.isPalindromeDescendant(21);
        boolean expected = false;
        assertEquals(expected, actual);
    }
}
