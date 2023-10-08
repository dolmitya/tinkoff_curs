package edu.hw1;

import java.util.Arrays;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;

@SuppressWarnings("uncommentedmain")
public class Task6 {
    private Task6() {
    }

    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    public static int countK(int x) {
        int result = 1;
        final int tis = 1000;
        final int POST_KAPR = 6174;
        final int des = 10;
        int copx = x;
        final int n = 4;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = copx % des;
            copx = copx / des;
        }
        Arrays.sort(a);
        int minx = 0;
        int maxx = 0;
        int mn1 = 1;
        int mn2 = tis;
        for (int i = 0; i < n; i++) {
            maxx += mn1 * a[i];
            minx += mn2 * a[i];
            mn1 *= des;
            mn2 /= des;
        }
        Integer raz = maxx - minx;
        if (!raz.equals(POST_KAPR)) {
            result += countK(raz);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        LOGGER.info("Input a digit: ");
        int x = cin.nextInt();
        LOGGER.info(countK(x));
        cin.close();
    }
}
