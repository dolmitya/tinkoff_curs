package edu.hw3.task8;

import edu.hw3.Task3;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class Task8Test {

    @Test
    @DisplayName("Тест123")
    void test123() {
        BackwardIterator<Integer> it = new BackwardIterator<>(List.of(1, 2, 3));
        Integer actual = it.next();
        Integer expected = 1;
        assertEquals(expected, actual);
    }
}
