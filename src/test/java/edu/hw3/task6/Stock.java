package edu.hw3.task6;

import java.util.Random;

public class Stock implements Comparable<Stock>{

    private int price;
    final static int THOUSAND = 1000;
    public Stock()
    {
        Random random = new Random();
        price = random.nextInt(THOUSAND) + 1;
    }

    public Stock(int money)
    {
        price = money;
    }

    int getPrice() {
        return price;
    }

    public int compareTo(Stock obj) {
        if (obj.getPrice() > price) {
            return 1;
        } else if (obj.getPrice() < price) {
            return -1;
        } else {
            return 0;
        }
    }
}
