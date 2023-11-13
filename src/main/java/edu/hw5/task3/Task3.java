package edu.hw5.task3;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {
    private final static Pattern FIRST_PATTERN =
        Pattern.compile("^(0|[1-9]\\d*)-(0[1-9]|1[0-2])-(0[1-9]|[1-2]\\d|3[0-1])$");

    private final static Pattern SECOND_PATTERN =
        Pattern.compile("^(0|[1-9]\\d*)-([1-9]|1[0-2])-([1-9]|[1-2]\\d|3[0-1])$");

    private final static Pattern THIRD_PATTERN =
        Pattern.compile("^([1-9]|1[0-2])/([1-9]|[1-2]\\d|3[0-1])/(0\\d|[1-9]\\d)$");

    private final static Pattern FOURTH_PATTERN =
        Pattern.compile("^([1-9]|1[0-2])/([1-9]|[1-2]\\d|3[0-1])/(0|[1-9]\\d*)$");

    private final static Pattern FIFTH_PATTERN =
        Pattern.compile("^tomorrow$");

    private final static Pattern SIXTH_PATTERN =
        Pattern.compile("^today$");

    private final static Pattern SEVENTH_PATTERN =
        Pattern.compile("^yesterday$");

    private final static Pattern EIGHTH_PATTERN =
        Pattern.compile("^1 day ago$");

    private final static Pattern NINTH_PATTERN =
        Pattern.compile("^(1\\d+|[2-9]\\d*) days ago$");

    private final static List<Pattern> LIST_OF_PATTERN =
        List.of(
            FIRST_PATTERN,
            SECOND_PATTERN,
            THIRD_PATTERN,
            FOURTH_PATTERN,
            FIFTH_PATTERN,
            SIXTH_PATTERN,
            SEVENTH_PATTERN,
            EIGHTH_PATTERN,
            NINTH_PATTERN
        );

    private final static int FOURTH_PATTERN_MATCH = 3;

    private final static int FIFTH_PATTERN_MATCH = 4;

    private final static int SIXTH_PATTERN_MATCH = 5;

    private final static int SEVENTH_PATTERN_MATCH = 6;

    private final static int EIGHTH_PATTERN_MATCH = 7;

    private Task3() {

    }

    public static Optional<LocalDate> parseDate(String string) {
        if (string == null) {
            return Optional.empty();
        }
        boolean isMatch = false;
        LocalDate resultDate = null;
        for (int i = 0; i < LIST_OF_PATTERN.size() && !isMatch; ++i) {
            Matcher matcher = LIST_OF_PATTERN.get(i).matcher(string);
            if (matcher.find()) {
                isMatch = true;
                switch (i) {
                    case 0, 1 -> {
                        String[] parseDate = string.split("-");
                        resultDate = LocalDate.of(
                            Integer.parseInt(parseDate[0]),
                            Integer.parseInt(parseDate[1]),
                            Integer.parseInt(parseDate[2])
                        );
                        break;
                    }
                    case 2 -> {
                        String[] parseDate = string.split("/");
                        resultDate = LocalDate.of(
                            Integer.parseInt("20" + parseDate[2]),
                            Integer.parseInt(parseDate[0]),
                            Integer.parseInt(parseDate[1])
                        );
                        break;
                    }
                    case FOURTH_PATTERN_MATCH -> {

                        String[] parseDate = string.split("/");
                        resultDate = LocalDate.of(
                            Integer.parseInt(parseDate[2]),
                            Integer.parseInt(parseDate[0]),
                            Integer.parseInt(parseDate[1])
                        );
                        break;
                    }
                    case FIFTH_PATTERN_MATCH -> {
                        resultDate = LocalDate.now().plusDays(1);
                        break;
                    }
                    case SIXTH_PATTERN_MATCH -> {
                        resultDate = LocalDate.now();
                        break;
                    }
                    case SEVENTH_PATTERN_MATCH, EIGHTH_PATTERN_MATCH -> {
                        resultDate = LocalDate.now().minusDays(1);
                        break;
                    }
                    default -> {
                        String[] parseDate = string.split(" ");
                        resultDate = LocalDate.now().minusDays(Integer.parseInt(parseDate[0]));
                        break;
                    }
                }
            }
        }
        return Optional.ofNullable(resultDate);
    }
}
