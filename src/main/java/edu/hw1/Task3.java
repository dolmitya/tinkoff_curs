package edu.hw1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;

@SuppressWarnings("uncommentedmain")

public class Task3 {
    private Task3() {
    }

    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    public static boolean isNestable(int[] a1, int[] a2) {
        boolean result = false;
        int l1 = a1.length;
        int l2 = a2.length;
        int mina1 = a1[0], maxa1 = a1[0], mina2 = a2[0], maxa2 = a2[0];
        for (int i = 1; i < l1; i++) {
            if (a1[i] < mina1) {
                mina1 = a1[i];
            }
            if (a1[i] > maxa1) {
                maxa1 = a1[i];
            }
        }
        for (int i = 1; i < l2; i++) {
            if (a2[i] < mina2) {
                mina2 = a2[i];
            }
            if (a2[i] > maxa2) {
                maxa2 = a2[i];
            }
        }
        if (mina1 > mina2 & maxa1 < maxa2) {
            result = true;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        LOGGER.info("Input a length mas1: ");
        int l1 = cin.nextInt();
        int[] mas1 = new int[l1];
        LOGGER.info("Input a mas1: ");
        for (int i = 0; i < l1; i++) {
            mas1[i] = cin.nextInt();
        }
        LOGGER.info("Input a length mas2: ");
        int l2 = cin.nextInt();
        int[] mas2 = new int[l2];
        LOGGER.info("Input a mas2: ");
        for (int i = 0; i < l2; i++) {
            mas2[i] = cin.nextInt();
        }
        System.out.print(isNestable(mas1, mas2));
        cin.close();
    }
}
