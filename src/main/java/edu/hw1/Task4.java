package edu.hw1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;

public class Task4 {
    private Task4() {
    }

    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    public static String fixString(String s) {
        String result = s;
        for (int i = 1; i < s.length(); i += 2) {
            result = result.substring(0, i - 1) + s.charAt(i) + result.substring(i);
            result = result.substring(0, i) + s.charAt(i - 1) + result.substring(i + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        LOGGER.info("Input a string: ");
        String s = cin.nextLine();
        LOGGER.info(fixString(s));
        cin.close();
    }
}
