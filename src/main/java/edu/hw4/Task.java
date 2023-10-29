package edu.hw4;

import java.util.List;
import java.util.stream.Collectors;

public class Task {
    private Task() {
    }

    public List<Animal> task1(List<Animal> animals) {
        List<Animal> result = animals.sort((o1, o2) -> {
            if (o1.height() > o2.height()) {
                return true;
            } else if (o1.height() < o2.height()) {
                return -1;
            } else {
                return 0;
            }
        });
        return result;
    }
}
