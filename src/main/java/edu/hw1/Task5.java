package edu.hw1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;

@SuppressWarnings("uncommentedmain")
public class Task5 {
    final static int STO = 100;
    final static int DES = 10;
    final static int MAX_CIF = 9;

    private Task5() {
    }

    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    private static int izm(int x) {
        int copx = x;
        int result = 0;
        int mn = 1;
        while (copx > 0) {
            result += (copx % STO / DES + copx % DES) * mn;
            copx = copx / STO;
            mn *= DES;
        }
        return result;
    }

    private static boolean isPalindrome(int integer) {
        int palindrome = integer;
        int reverse = 0;
        while (palindrome != 0) {
            int remainder = palindrome % DES;
            reverse = reverse * DES + remainder;
            palindrome = palindrome / DES;
        }
        return integer == reverse;
    }

    public static boolean isPalindromeDescendant(int x) {
        int copx = x;
        boolean result = false;
        String strX = Integer.toString(x);
        if (strX.length() % 2 == 0) {
            while (!result && copx > MAX_CIF) {
                if (isPalindrome(copx)) {
                    result = true;
                } else {
                    copx = izm(copx);
                }
            }
        } else {
            result = isPalindrome(copx);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        LOGGER.info("Input a digit: ");
        int x = cin.nextInt();
        LOGGER.info(isPalindromeDescendant(x));
        cin.close();
    }
}
