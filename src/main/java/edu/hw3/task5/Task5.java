package edu.hw3.task5;

import java.util.List;

public class Task5 {
    public Task5() {
    }

    public List<String> parseContacts(List<String> list, String isComp) {
        if (isComp.equals("ASC")) {
            list.sort(new MyComparator1());
        } else {
            list.sort(new MyComparator2());
        }
        return list;
    }
}
