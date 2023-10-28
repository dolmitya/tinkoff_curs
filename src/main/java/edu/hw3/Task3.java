package edu.hw3;

import java.util.HashMap;
import java.util.List;

public class Task3 {
    private Task3() {
    }

    public static HashMap<Object, Integer> freqDict(List<?> list) {
        HashMap<Object, Integer> map = new HashMap<>();
        Object s;
        for (int i = 0; i < list.size(); i++) {
            s = list.get(i);
            if (map.containsKey(s)) {
                map.replace(s, map.get(s), map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        return map;
    }
}
