package edu.hw3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import org.apache.logging.log4j.LogManager;

@SuppressWarnings("uncommentedmain")
public class Task2 {
    private Task2() {
    }

    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    public static String clusterize(String s) {
        List<String> list = new ArrayList<>();
        Stack<Character> st = new Stack<>();
        Boolean flag = true;
        String str = "\"";
        for (int i = 0; i < s.length() && flag; i++) {
            if (s.charAt(i) == '(') {
                st.push(s.charAt(i));
                str = str + s.charAt(i);
            } else if (s.charAt(i) == ')') {
                if (st.empty() || st.pop() != '(') {
                    flag = false;
                } else {
                    str = str + s.charAt(i);
                }
            } else {
                flag = false;
            }
            if (st.empty()) {
                list.add(str + "\"");
                str = "\"";
            }
        }
        return (flag && st.empty() ? list.toString() : "");
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        LOGGER.info("Input a string: ");
        String str = cin.nextLine();
        LOGGER.info(clusterize(str));
        cin.close();
    }
}
