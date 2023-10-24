package edu.hw3;

import java.util.LinkedHashMap;
import java.util.List;

public class Task3 {
    private Task3() {
    }

    public static LinkedHashMap<String, Integer> freqDict(List<String> list) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        String s;
        for (int i = 0; i < list.size(); i++) {
            s = "\"" + list.get(i) + "\"";
            if (map.containsKey(s)) {
                map.replace(s, map.get(s), map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        return map;
    }
}
