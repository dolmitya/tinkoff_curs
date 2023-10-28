package edu.hw3.task6;

import java.util.PriorityQueue;

interface StockMarket {
    /** Добавить акцию */
    void add(Stock stock);

    /** Удалить акцию */
    void remove(Stock stock);

    /** Самая дорогая акция */
    Stock mostValuableStock();
}

public class Market implements StockMarket{
    private final PriorityQueue<Stock> priorityQueue = new PriorityQueue<>();

    public PriorityQueue<Stock> getPriorityQueue() {
        return priorityQueue;
    }

    public void add(Stock stock) {
        priorityQueue.add(stock);
    }

    public void remove(Stock stock) {
        if (!priorityQueue.isEmpty()) {
            priorityQueue.remove(stock);
        }
    }

    @Override
    public Stock mostValuableStock() {
        return priorityQueue.peek();
    }
}
