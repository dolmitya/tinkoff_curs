package edu.hw5.task1;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Task1 {
    private Task1() {}

    //Вас попросили сделать аналитику для компьютерного клуба: нужно посчитать, сколько времени в среднем посетители проводят времени за один сеанс.
    //На вход функции даётся набор строк вида 2022-03-12, 20:20 - 2022-03-12, 23:50.
    public static String averageSessionTime(List<String> sessions) {
        List<Long> durations = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");

        for (String session: sessions) {
            String[] parts = session.split(" - ");
            if (parts.length != 2) {
                throw new IllegalArgumentException("Передан неверный формат сессии");
            }

            LocalDateTime from = LocalDateTime.from(formatter.parse(parts[0]));
            LocalDateTime to = LocalDateTime.from(formatter.parse(parts[1]));

            if (!from.isBefore(to)) {
                throw new IllegalArgumentException("Переданы некорректные данные");
            }

            if (!from.plusDays(1).isAfter(to)) {
                throw new IllegalArgumentException("Сессия больше суток");
            }

            durations.add(Duration.between(from, to).toMillis()); // продолжительность сессии в миллисекундах
        }

        long averageDuration = (long) durations.stream()
            .mapToDouble(Long::doubleValue)
            .average()
            .orElse(0.0);

        return DateTimeFormatter
            .ofPattern("Hч mmм")
            .withZone(ZoneOffset.UTC)
            .format(Instant.ofEpochMilli(averageDuration));
    }

    final static int SECOND_DATE = 5;
    final static int FIRST_DATE = 1;
    public static final Pattern DATA_PATTERN = Pattern.compile("^(\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2]\\d|3[0-1]),"
        + " ([0-1]\\d|2[0-4]):[0-5]\\d) - (\\d{4}-(0[1-9]|1[0-2])"
        + "-(0[1-9]|[1-2]\\d|3[0-1]), ([0-1]\\d|2[0-4]):[0-5]\\d)$"); //2004-09-10

    public static Duration getDuration(List<String> baseTime) {
        SimpleDateFormat formatter = new SimpleDateFormat("y-MM-dd, HH:mm");
        int sessionCount = 0;
        int fullDuration = 0;
        if (baseTime.isEmpty()) {
            throw new RuntimeException("the passed values are empty");
        }
        for (String session : baseTime) {
            Matcher matcher = DATA_PATTERN.matcher(session);

            if (matcher.find()) {
                try {
                    Date first = formatter.parse(matcher.group(FIRST_DATE));
                    Date end = formatter.parse(matcher.group(SECOND_DATE));
                    fullDuration += (int) Duration.between(first.toInstant(), end.toInstant()).getSeconds();
                    ++sessionCount;
                } catch (ParseException e) {
                    throw new RuntimeException("Parse Exeption");
                }

            } else {
                throw new RuntimeException("Invalid data format");
            }
        }
        return Duration.ofSeconds((long) fullDuration / sessionCount);
    }
}
