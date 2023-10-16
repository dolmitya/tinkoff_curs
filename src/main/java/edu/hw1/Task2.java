package edu.hw1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;

@SuppressWarnings("uncommentedmain")
public class Task2 {
    private Task2() {
    }

    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    public static int countDigits(int dig) {
        final int del = 10;
        int result = 0;
        int x = Math.abs(dig);
        while (x > 0) {
            x = x / del;
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        LOGGER.info("Input a digits: ");
        int dig = cin.nextInt();
        LOGGER.info(countDigits(dig));
        cin.close();
    }
}
