package edu.hw4;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task {
    public Task() {
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

    public List<Animal> task2(List<Animal> animals) {
        List<Animal> result = animals.stream()
            .sorted((o1, o2) -> {
                if (o1.weight() < o2.weight()) {
                    return 1;
                } else if (o1.weight() > o2.weight()) {
                    return -1;
                }
                return 0;
            }).collect(Collectors.toList());
        return result;
    }

    public Map<Animal.Type, Integer> task3(List<Animal> animals) {
        Map<Animal.Type, Integer> result = new HashMap<Animal.Type, Integer>();
        Stream stream = animals.stream();
        stream.filter(x-> x.toString().length() == 3).forEach(System.out::println);
        return result;
    }
}
