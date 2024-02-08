package edu.hw5.task6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task6 {
    private Task6() {

    }

    public static boolean isSubsequence(String subsequence, String str) {
        boolean result = false;
        if (str != null && subsequence != null) {
            char[] subsequent = subsequence.toCharArray();
            StringBuilder patern = new StringBuilder();
            for (char i : subsequent) {
                patern.append(i);
                patern.append("\\w*");
            }
            Pattern subsequencePatter = Pattern.compile(patern.toString());
            Matcher matcher = subsequencePatter.matcher(str);
            if (matcher.find()) {
                result = true;
            }
        }
        return result;
    }
}
