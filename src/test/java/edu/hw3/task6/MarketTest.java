package edu.hw3.task6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MarketTest {

    @Test
    @DisplayName("Добавление элементов в очередь")
    void add() {
        Market m = new Market();
        Stock action = new Stock(100);
        m.add(action);
        var queue = m.getPriorityQueue();
        int actual = queue.remove().getPrice();
        int expected=100;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Удаление нужного элемента маркета")
    void remove() {
        Market m = new Market();
        Stock action1 = new Stock(200);
        m.add(action1);
        Stock action2 = new Stock(100);
        m.add(action2);
        var queue = m.getPriorityQueue();
        queue.remove();
        int actual = queue.remove().getPrice();
        int expected=100;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Возврещение акции максимальной цены")
    void mostValuableStock() {
        Market m = new Market();
        Stock action1 = new Stock(200);
        m.add(action1);
        Stock action2 = new Stock(100);
        m.add(action2);
        Stock action3 = new Stock(400);
        m.add(action3);
        Stock action4 = new Stock(230);
        m.add(action4);
        int actual = m.mostValuableStock().getPrice();
        int expected=400;
        assertEquals(expected, actual);
    }
}
