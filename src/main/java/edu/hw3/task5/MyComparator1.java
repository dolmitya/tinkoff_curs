package edu.hw3.task5;

import java.util.Comparator;

class MyComparator1 implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        String s1 = o1.toString();
        String s2 = o2.toString();
        s1 = s1.substring(s1.indexOf(' ') + 1);
        s2 = s2.substring(s2.indexOf(' ') + 1);
        return -s2.compareTo(s1);
    }
}
