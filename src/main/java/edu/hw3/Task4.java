package edu.hw3;

import java.util.HashMap;

public class Task4 {
    private Task4() {
    }

    final static int FIVE = 5;
    final static int TEN = 10;
    final static int FIFTY = 50;
    final static int HUNDRED = 100;
    final static int FIVEHUNDRED = 500;
    final static int THOUSAND = 1000;
    private static HashMap<Integer, String> map;

    private static void encoder() {
        map = new HashMap<>();
        map.put(THOUSAND, "M");
        map.put(FIVEHUNDRED, "D");
        map.put(HUNDRED, "C");
        map.put(FIFTY, "L");
        map.put(TEN, "X");
        map.put(FIVE, "V");
        map.put(1, "I");
    }

    public static String convertToRoman(int num) {
        encoder();
        int res = num;
        StringBuilder ret = new StringBuilder();
        if (res == 0) {
            return "N";
        }

        int i = 0;
        Integer value = THOUSAND;
        String key;

        do {
            key = map.get(value);
            var d = res / value;
            res = res % value;
            for (int j = 0; j < d; j++) {
                ret.append(key);
            }
            if (i % 2 == 0) {
                value /= 2;
            } else {
                value /= FIVE;
            }
            i++;
        } while (value > 0);

        return ret.toString();
    }
}
