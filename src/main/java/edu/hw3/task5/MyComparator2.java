package edu.hw3.task5;

import java.util.Comparator;

class MyComparator2 implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        MyComparator1 comp = new MyComparator1();
        String s1 = o1.toString();
        String s2 = o2.toString();
        return -comp.compare(s1, s2);
    }
}
