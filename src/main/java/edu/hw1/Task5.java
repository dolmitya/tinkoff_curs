package edu.hw1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;

@SuppressWarnings("uncommentedmain")
public class Task5 {
    private Task5() {
    }

    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    public static int izm(int x) {
        int result = 0;
        int mn = 1;
        while (x > 0) {
            result += (x % 100 / 10 + x % 10) * mn;
            x = x / 100;
            mn *= 10;
        }
        return result;
    }

    public static boolean isPalindrome(int integer) {
        int palindrome = integer;
        int reverse = 0;
        while (palindrome != 0) {
            int remainder = palindrome % 10;
            reverse = reverse * 10 + remainder;
            palindrome = palindrome / 10;
        }
        return integer == reverse;
    }

    public static boolean isPalindromeDescendant(int x) {
        boolean result = false;
        while (!result && x > 9) {
            if (isPalindrome(x)) {
                result = true;
            } else {
                x = izm(x);
            }
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
