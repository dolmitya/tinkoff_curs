package edu.project1;

@SuppressWarnings("uncommentedmain")
public class Init {

    private static final RandomWordSelector WORDSELECTOR = new RandomWordSelector();

    private Init() {
    }

    public static void main(String[] args) {
        Game initialization = new Game();
        initialization.start(WORDSELECTOR.getRandomWord());
    }
}
