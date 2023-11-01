package edu.hw2.task4;

import edu.hw2.task1.Expr;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task4Test {

    @Test
    @DisplayName("Тест к заданию 4")
    void test4() {
        Task4.CallingInfo actual = Task4.callingInfo();
        Task4.CallingInfo expected = new Task4.CallingInfo("edu.hw2.task4.Task4Test","test4");
        assertEquals(expected, actual);
    }
}
