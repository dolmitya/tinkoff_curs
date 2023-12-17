package edu.hw10.task2;

public interface FibCalculator {
    @Cache(persist = true)
    public long fib(int number);
}
