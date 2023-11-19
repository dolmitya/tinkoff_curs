package edu.project3;

import java.time.LocalDateTime;
import java.util.function.Predicate;

public class DateTimeToFilter implements Predicate<LocalDateTime> {
    private final LocalDateTime to;

    public DateTimeToFilter(LocalDateTime to) {
        this.to = to;
    }

    //Evaluates this predicate on the given argument
    @Override
    public boolean test(LocalDateTime localDateTime) {
        return !localDateTime.isAfter(to);
    }
}
