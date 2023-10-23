package edu.hw3;

import java.util.HashMap;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;

@SuppressWarnings("uncommentedmain")
public class Task1 {
    private Task1() {
    }

    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    private static HashMap<Character, Character> hashMap;

    private static void encoder() {
        hashMap = new HashMap<>();
        for (char l = 'a', r = 'z'; l <= 'm' && 'n' <= r; ++l, --r) {
            hashMap.put(l, r);
            hashMap.put(r, l);
        }
        for (char l = 'A', r = 'Z'; l <= 'M' && 'N' <= r; ++l, --r) {
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

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        LOGGER.info("Input a string: ");
        String str = cin.nextLine();
        LOGGER.info(atbash(str));
        cin.close();
    }
}
