package edu.hw1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;

@SuppressWarnings("uncommentedmain")

public class Task7 {
    private Task7() {
    }

    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    public static int rotateRight(int dig, int kol) {
        final int del = 2;
        int result = 0;
        String binary = Integer.toBinaryString(dig);
        for (int i = 0; i < kol; i++) {
            binary = binary.charAt(binary.length() - 1) + binary.substring(0, binary.length() - 1);
        }
        result = Integer.parseInt(binary, 2);
        return result;
    }

    public static int rotateLeft(int dig, int kol) {
        final int del = 2;
        int result = 0;
        String binary = Integer.toBinaryString(dig);
        for (int i = 0; i < kol; i++) {
            binary = binary.substring(1, binary.length()) + binary.charAt(0);
        }
        result = Integer.parseInt(binary, 2);
        return result;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        LOGGER.info("Input a digits: ");
        int dig = cin.nextInt();
        LOGGER.info("Input a kol: ");
        int kol = cin.nextInt();
        LOGGER.info(rotateRight(dig, kol));
        LOGGER.info(rotateLeft(dig, kol));
        cin.close();
    }
}
