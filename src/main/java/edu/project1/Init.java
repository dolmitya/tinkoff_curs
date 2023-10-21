package edu.project1;

@SuppressWarnings("uncommentedmain")
public class Init {
    private Init() {
    }

    private static final RandomWordSelector wordSelector = new RandomWordSelector();

    public static void main(String[] args) {
        Game initialization = new Game();
        initialization.start(wordSelector.getRandomWord());
    }
}
