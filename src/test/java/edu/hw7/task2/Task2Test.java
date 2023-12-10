package edu.hw7.task2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.math.BigInteger;
import static org.junit.jupiter.api.Assertions.*;

class Task2Test {
    @Test
    @DisplayName("Факториал числа считается правильно")
    void test1() {
        int num = 5;
        assertEquals(new BigInteger("120"), Task2.factorialOfNumber(num));
    }

    @Test
    @DisplayName("Факториал числа 1")
    void test2() {
        int num = 1;
        assertEquals(new BigInteger("1"), Task2.factorialOfNumber(num));
    }

    @Test
    @DisplayName("Факториал числа 0")
    void test3() {
        int num = 0;
        assertEquals(new BigInteger("1"), Task2.factorialOfNumber(num));
    }

    @Test
    @DisplayName("Факториал отрицательного числа")
    void test4() {
        int num = -1;
        assertEquals(new BigInteger("1"), Task2.factorialOfNumber(num));
    }

    @Test
    @DisplayName("Факториал правильно считается даже для больших чисел")
    void test5() {
        int num = 30;
        assertEquals(new BigInteger("265252859812191058636308480000000"), Task2.factorialOfNumber(num));
    }
}
