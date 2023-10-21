package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    @DisplayName("Пустая строка")
    void start() {
        Game initialization = new Game();
        boolean actual = initialization.start("");
        boolean expected = false;
        assertEquals(expected, actual);
    }
}
