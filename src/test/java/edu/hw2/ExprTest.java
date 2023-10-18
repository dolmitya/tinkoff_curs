package edu.hw2;

import edu.hw2.task1.Expr;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExprTest {
    @Test
    @DisplayName("Сложение")
    void Add() {
        var two = new Expr.Constant(2);
        var four = new Expr.Constant(4);
        var actual = new Expr.Addition(two, four).evaluate();
        var expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Отрицание")
    void Neg() {
        var ten = new Expr.Constant(10);
        var actual = new Expr.Negate(ten).evaluate();
        var expected = -10;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Отрицание")
    void Neg0() {
        var nul = new Expr.Constant(0);
        var actual = new Expr.Negate(nul).evaluate();
        var expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Умножение")
    void Mul() {
        var two = new Expr.Constant(3);
        var four = new Expr.Constant(7);
        var actual = new Expr.Multiplication(two, four).evaluate();
        var expected = 21;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Степень")
    void Exp() {
        var five = new Expr.Constant(5);
        var actual = new Expr.Exponent(five, 3).evaluate();
        var expected = 125;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Степень -1 для 0")
    void Exp0() {
        var nul = new Expr.Constant(0);
        var actual = new Expr.Exponent(nul, -1).evaluate();
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }
}
