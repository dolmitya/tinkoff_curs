package edu.hw3.task3;

import java.util.HashMap;
import java.util.List;

public class Task3 {
    private Task3() {
    }

    public static <T> HashMap<T, Integer> freqDict(List<T> list) {
        HashMap<T, Integer> map = new HashMap<>();
        for (T t : list) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        return map;
    }
}
