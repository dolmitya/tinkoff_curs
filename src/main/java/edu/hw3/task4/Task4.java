package edu.hw3.task4;

import java.util.LinkedHashMap;
import java.util.Map;

public class Task4 {
    private final static int FOUR = 4;
    private final static int FIVE = 5;
    private final static int NINE = 9;
    private final static int TEN = 10;
    private final static int FOURTY = 40;
    private final static int FIFTY = 50;
    private final static int NINETY = 90;
    private final static int HUNDRED = 100;
    private final static int FOURHUNDRED = 400;
    private final static int FIVEHUNDRED = 500;
    private  final static int NINEHUNDRED = 900;
    private  final static int THOUSAND = 1000;
    private static LinkedHashMap<Integer, String> map;

    private Task4() {
    }

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
            ret.append(String.valueOf(value).repeat(Math.max(0, d)));
        }

        return ret.toString();
    }
}
