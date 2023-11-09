package edu.hw3.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Task2 {
    private Task2() {
    }

    public static List<String> clusterize(String s) {
        List<String> result = new ArrayList<>();
        Stack<Character> st = new Stack<>();
        boolean flag = true;
        StringBuilder str = new StringBuilder("\"");
        for (int i = 0; i < s.length() && flag; i++) {
            if (s.charAt(i) == '(') {
                st.push(s.charAt(i));
                str.append(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if (st.empty() || st.pop() != '(') {
                    flag = false;
                } else {
                    str.append(s.charAt(i));
                }
            } else {
                flag = false;
            }
            if (st.empty()) {
                result.add(str + "\"");
                str.delete(0, str.length()).append("\"");
            }
        }
        return (flag && st.empty() ? result : null);
    }
}
