package edu.hw3.task8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class Task8Test {

    @Test
    @DisplayName("Тест123")
    void test123() {
        BackwardIterator<Integer> it = new BackwardIterator<>(Integer.class, List.of(1, 2, 3));
        Integer actual = it.next();
        Integer expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Тест187532")
    void test187532() {
        BackwardIterator<Integer> it = new BackwardIterator<>(Integer.class, List.of(1, 8, 7, 5, 3, 2));
        Integer actual = it.next();
        actual = it.next();
        Integer expected = 3;
        assertEquals(expected, actual);
    }
}
