package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task {
    private Task() {
    }

    public List<Animal> task1(List<Animal> animals) {
        List<Animal> result = animals.stream()
            .sorted((o1, o2) -> {
                if (o1.height() > o2.height()) {
                    return 1;
                } else if (o1.height() < o2.height()) {
                    return -1;
                }
                return 0;
            }).collect(Collectors.toList());
        return result;
    }
}
