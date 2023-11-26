package edu.hw7.task1;

import java.util.concurrent.atomic.AtomicInteger;

public class Task1 {
    private Task1() {
    }

    public static int parallelIncrement() {
        AtomicInteger integer = new AtomicInteger(0);
        var tread1 = new Thread(integer::incrementAndGet);
        var tread2 = new Thread(integer::incrementAndGet);
        tread1.start();
        tread2.start();
        try {
            tread1.join();
            tread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return integer.get();
    }
}
