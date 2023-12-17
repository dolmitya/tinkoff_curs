package edu.hw10.task1;

public record MyRecord(@Min(1000) int x, @NotNull String string, @NotNull Boolean is) {
}
