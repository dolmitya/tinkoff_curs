package edu.hw3.task6;

import java.util.Random;

public class Stock implements Comparable<Stock> {

    private final int price;

    private final static int THOUSAND = 1000;

    public Stock() {
        Random random = new Random();
        price = random.nextInt(THOUSAND) + 1;
    }

    public Stock(int money) {
        price = money;
    }

    public int getPrice() {
        return price;
    }

    public int compareTo(Stock obj) {
        return Integer.compare(obj.getPrice(), price);
    }
}
