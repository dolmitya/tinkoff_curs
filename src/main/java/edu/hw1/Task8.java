package edu.hw1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;

@SuppressWarnings("uncommentedmain")
public class Task8 {
    final static int ONE = 1;
    final static int TWO = 2;
    final static int N = 8;

    private Task8() {
    }

    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    private static boolean to(int[][] array, int i, int j) {
        boolean result = false;
        if ((i + TWO < N && j + ONE < N && array[i + TWO][j + ONE] == ONE)
            || (i + TWO < N && j - ONE >= 0 && array[i + TWO][j - ONE] == ONE)
            || (i - TWO >= 0 && j + ONE < N && array[i - TWO][j + ONE] == ONE)
            || (i - TWO >= 0 && j - ONE >= 0 && array[i - TWO][j - ONE] == ONE)) {
            result = true;
        }
        return result;
    }

    private static boolean ot(int[][] array, int i, int j) {
        boolean result = false;
        if ((i + ONE < N && j + TWO < N && array[i + ONE][j + TWO] == ONE)
            || (i + ONE < N && j - TWO >= 0 && array[i + ONE][j - TWO] == ONE)
            || (i - ONE >= 0 && j + TWO < N && array[i - ONE][j + TWO] == ONE)
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
        for (int i = 0; i < N && result; i++) {
            for (int j = 0; j < N && result; j++) {
                if (isFight(array, i, j)) {
                    result = false;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int[][] array = new int[N][N];
        LOGGER.info("Input a array: ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                array[i][j] = cin.nextInt();
            }
        }
        LOGGER.info(knightBoardCapture(array));
        cin.close();
    }
}
