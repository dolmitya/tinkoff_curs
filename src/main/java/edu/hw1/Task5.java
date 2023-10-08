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
        int result = 0;
        int mn = 1;
        while (x > 0) {
            result += (x % c2 / c1 + x % c1) * mn;
            x /= c2;
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
