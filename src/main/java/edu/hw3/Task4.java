package edu.hw3;

import java.util.LinkedHashMap;
import java.util.Map;

public class Task4 {
    private Task4() {
    }

    final static int FOUR = 4;
    final static int FIVE = 5;
    final static int NINE = 9;
    final static int TEN = 10;
    final static int FOURTY = 40;
    final static int FIFTY = 50;
    final static int NINETY = 90;
    final static int HUNDRED = 100;
    final static int FOURHUNDRED = 400;
    final static int FIVEHUNDRED = 500;
    final static int NINEHUNDRED = 900;
    final static int THOUSAND = 1000;
    private static LinkedHashMap<Integer, String> map;

    private static void encoder() {
        map = new LinkedHashMap<>();
        map.put(THOUSAND, "M");
        map.put(NINEHUNDRED, "CM");
        map.put(FIVEHUNDRED, "D");
        map.put(FOURHUNDRED, "CD");
        map.put(HUNDRED, "C");
        map.put(NINETY, "XC");
        map.put(FIFTY, "L");
        map.put(FOURTY, "XL");
        map.put(TEN, "X");
        map.put(NINE, "IX");
        map.put(FIVE, "V");
        map.put(FOUR, "IV");
        map.put(1, "I");
    }

    public static String convertToRoman(int num) {
        encoder();
        int res = num;
        StringBuilder ret = new StringBuilder();
        if (res == 0) {
            return "N";
        }

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            var d = res / key;
            res = res % key;
            for (int j = 0; j < d; j++) {
                ret.append(value);
            }
        }

        return ret.toString();
    }
}
