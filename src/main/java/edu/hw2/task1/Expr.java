package edu.hw2.task1;

public sealed interface Expr permits Expr.Addition, Expr.Constant, Expr.Negate, Expr.Multiplication, Expr.Exponent {
    double evaluate();

    public record Constant(double value) implements Expr {
        public double evaluate() {
            return value;
        }
    }

    public record Addition(Expr first, Expr second) implements Expr {
        public double evaluate() {
            return first.evaluate() + second.evaluate();
        }
    }

    public record Negate(Expr value) implements Expr {
        public double evaluate() {
            if (value.evaluate() != 0) {
                return -value.evaluate();
            } else {
                return value.evaluate();
            }
        }
    }

    public record Multiplication(Expr first, Expr second) implements Expr {
        public double evaluate() {
            return first.evaluate() * second.evaluate();
        }
    }

    public record Exponent(Expr val, int n) implements Expr {
        public double evaluate() {
            return Math.pow(val.evaluate(), n);
        }
    }
}
