package edu.hw4;

public record Animal(
    String name,
    Type type,
    Sex sex,
    int age,
    int height,
    int weight,
    boolean bites
) {
    enum Type {
        CAT, DOG, BIRD, FISH, SPIDER
    }

    enum Sex {
        M, F
    }

    public int paws() {
        final int POWS_CAt_DOG = 4;
        final int POWS_SPIDER = 8;
        return switch (type) {
            case CAT, DOG -> POWS_CAt_DOG;
            case BIRD -> 2;
            case FISH -> 0;
            case SPIDER -> POWS_SPIDER;
        };
    }
}
