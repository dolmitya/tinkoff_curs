package edu.hw1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;

@SuppressWarnings("uncommentedmain")
public class Task5 {
    private Task5() {
    }

    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    public static int izm(int x) {
        final int c2 = 100;
        final int c1 = 10;
        int copx = x;
        int result = 0;
        int mn = 1;
        while (copx > 0) {
            result += (copx % c2 / c1 + copx % c1) * mn;
            copx = copx / c2;
            mn *= c1;
        }
        return result;
    }

    public static boolean isPalindrome(int integer) {
        final int des = 10;
        int palindrome = integer;
        int reverse = 0;
        while (palindrome != 0) {
            int remainder = palindrome % des;
            reverse = reverse * des + remainder;
            palindrome = palindrome / des;
        }
        return integer == reverse;
    }

    public static boolean isPalindromeDescendant(int x) {
        final int MAX_CIF = 9;
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
