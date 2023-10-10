package edu.hw1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;

@SuppressWarnings("uncommentedmain")

public class Task8 {

    final static int ONE = 1;
    final static int TWO = 2;
    final static int n = 8;

    private Task8() {
    }

    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    private static boolean to(int[][] array, int i, int j) {
        boolean result = false;
        if ((i + TWO < n && j + ONE < n && array[i + TWO][j + ONE] == ONE)
            || (i + TWO < n && j - ONE >= 0 && array[i + TWO][j - ONE] == ONE)
            || (i - TWO >= 0 && j + ONE < n && array[i - TWO][j + ONE] == ONE)
            || (i - TWO >= 0 && j - ONE >= 0 && array[i - TWO][j - ONE] == ONE)) {
            result = true;
        }
        return result;
    }

    private static boolean ot(int[][] array, int i, int j) {
        boolean result = false;
        if ((i + ONE < n && j + TWO < n && array[i + ONE][j + TWO] == ONE)
            || (i + ONE < n && j - TWO >= 0 && array[i + ONE][j - TWO] == ONE)
            || (i - ONE >= 0 && j + TWO < n && array[i - ONE][j + TWO] == ONE)
            || (i - ONE >= 0 && j - TWO >= 0 && array[i - ONE][j - TWO] == ONE)) {
            result = true;
        }
        return result;
    }

    private static boolean isFight(int[][] array, int i, int j) {
        boolean result = false;
        if ((array[i][j] == 1) && (to(array, i, j) || ot(array, i, j))) {
            result = true;
        }
        return result;
    }

    public static boolean knightBoardCapture(int[][] array) {
        boolean result = true;
        for (int i = 0; i < n && result; i++) {
            for (int j = 0; j < n && result; j++) {
                if (isFight(array, i, j)) {
                    result = false;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
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
