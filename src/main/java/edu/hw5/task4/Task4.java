package edu.hw5.task4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task4 {
    private final static Pattern PASSWORD_PATTERN = Pattern.compile("\\w*[~!@#$%^&*|]\\w*");

    private Task4() {
    }

    public static boolean isPassword(String password) {
        boolean result = false;
        if (password != null) {
            Matcher matcher = PASSWORD_PATTERN.matcher(password);
            if (matcher.find()) {
                result = true;
            }
        }
        return result;
    }
}
