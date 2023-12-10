package edu.hw3.task6;

import java.util.PriorityQueue;

public class Market implements StockMarket {
    private final PriorityQueue<Stock> priorityQueue = new PriorityQueue<>();

    public PriorityQueue<Stock> getPriorityQueue() {
        return priorityQueue;
    }

    public void add(Stock stock) {
        priorityQueue.add(stock);
    }

    public boolean remove(Stock stock) {
        if (!priorityQueue.isEmpty()) {
            priorityQueue.remove(stock);
            return true;
        }
        return false;
    }

    @Override
    public Stock mostValuableStock() {
        return priorityQueue.peek();
    }
}
