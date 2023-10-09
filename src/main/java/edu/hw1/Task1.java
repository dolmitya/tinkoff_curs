package edu.hw1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;

@SuppressWarnings("uncommentedmain")

public class Task1 {
    private Task1() {
    }

    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    public static Boolean check(String str) {
        Boolean result = true;
        Boolean flag = false;
        final int TREE = 3;
        for (int i = 0; i < str.length() & result; i++) {
            if ((str.charAt(i) == ':') && (!flag)) {
                flag = true;
            } else if ((str.charAt(i) < '0') || (str.charAt(i) > '9')) {
                result = false;
            }
        }
        return (result && flag && (str.charAt(str.length() - TREE) == ':'));
    }

    public static int minutToSeconds(String time) {
        final int maxv = 60;
        final int minv = 0;
        int result = -1;
        if (check(time)) {
            int pos = time.indexOf(":");
            int min = Integer.parseInt(time.substring(0, pos));
            int sec = Integer.parseInt(time.substring(pos + 1, time.length()));
            if (sec < maxv || sec > minv) {
                result = min * maxv + sec;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        LOGGER.info("Input a time: ");
        String time = cin.nextLine();
        LOGGER.info(minutToSeconds(time));
        cin.close();
    }
}
