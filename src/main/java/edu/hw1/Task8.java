package edu.hw1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;

@SuppressWarnings("uncommentedmain")

public class Task8 {
    private Task8() {
    }

    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    public static boolean knightBoardCapture(int[][] array) {
        final int n = 8;
        final int ONE = 1;
        final int TWO = 2;
        boolean result = true;
        for (int i = 0; i < n && result; i++) {
            for (int j = 0; j < n && result; j++) {
                if (array[i][j] == ONE) {
                    if ((i + TWO < n && j + ONE < n && array[i + TWO][j + ONE] == ONE) ||
                        (i + TWO < n && j - ONE >= 0 && array[i + TWO][j - ONE] == ONE) ||
                        (i - TWO >= 0 && j + ONE < n && array[i - TWO][j + ONE] == ONE) ||
                        (i - TWO >= 0 && j - ONE >= 0 && array[i - TWO][j - ONE] == ONE) ||
                        (i + ONE < n && j + TWO < n && array[i + ONE][j + TWO] == ONE) ||
                        (i + ONE < n && j - TWO >= 0 && array[i + ONE][j - TWO] == ONE) ||
                        (i - ONE >= 0 && j + TWO < n && array[i - ONE][j + TWO] == ONE) ||
                        (i - ONE >= 0 && j - TWO >= 0 && array[i - ONE][j - TWO] == ONE)) {
                        result = false;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        final int n = 8;
        int[][] array = new int[n][n];
        LOGGER.info("Input a array: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = cin.nextInt();
            }
        }
        LOGGER.info(knightBoardCapture(array));
        cin.close();
    }
}

