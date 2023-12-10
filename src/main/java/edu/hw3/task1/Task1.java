package edu.hw3.task1;

import java.util.HashMap;

public class Task1 {

    private static HashMap<Character, Character> hashMap;

    private Task1() {
    }

    private static void encoder() {
        hashMap = new HashMap<>();
        for (char l = 'a', r = 'z'; l <= 'm'; ++l, --r) {
            hashMap.put(l, r);
            hashMap.put(r, l);
        }
        for (char l = 'A', r = 'Z'; l <= 'M'; ++l, --r) {
            hashMap.put(l, r);
            hashMap.put(r, l);
        }
    }

    public static String atbash(String s) {
        encoder();
        String str = s;
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')) {
                str = str.substring(0, i) + hashMap.get(str.charAt(i)) + str.substring(i + 1);
            }
        }
        return str;
    }
}
