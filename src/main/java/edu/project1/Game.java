package edu.project1;

import java.util.Scanner;
import java.util.Set;
import org.apache.logging.log4j.LogManager;

@SuppressWarnings("uncommentedmain")
public class Game {
    final static int WRONG_COUNT_MISTAKES = 6;
    final static int MAX_COUNT_MISTAKES = 6;
    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();
    private final RandomWordSelector wordSelector = new RandomWordSelector();
    private final WordMask maskOperator = new WordMask();
    int mistakesCount;
    private String letter = "";

    private void input() {
        Scanner scanner = new Scanner(System.in);

        boolean flag = true;
        do {
            letter = scanner.nextLine();
            if (letter.length() == 1 && Character.isLetter(letter.charAt(0))) {
                flag = false;
            } else {
                if (letter.equals("give up")) {
                    mistakesCount = WRONG_COUNT_MISTAKES;
                    letter = " ";
                    return;
                }
                LOGGER.info("Input correct letter:");
            }
        } while (flag);
    }

    private boolean win(int numberGuessletter, Set<String> wordUniqueLetters) {
        return numberGuessletter == wordUniqueLetters.size();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        String vubor = "N";
        Boolean flag = false;
        while (true) {
            if (vubor.equalsIgnoreCase("N")) {
                mistakesCount = 0;
                maskOperator.clearBuffer();
                String guessedWord = wordSelector.getRandomWord();
                maskOperator.setWord(guessedWord);
                LOGGER.info("A word has been guessed!\nIf you want to give up, enter - give up\n");

                while (!win(maskOperator.getNumberGuessletter(), maskOperator.getWordUniqueLetters())) {
                    LOGGER.info("Guess a letter: ");
                    input();
                    if (mistakesCount == WRONG_COUNT_MISTAKES) {
                        LOGGER.info("You give up!");
                        flag = true;
                        break;
                    }
                    if (maskOperator.isLetterbeused(letter)) {
                        LOGGER.info("This letter is already by used!");
                    } else {
                        maskOperator.inputLetterInSet(letter);
                        if (maskOperator.checkLetterinSet(letter)) {
                            LOGGER.info("Hit!");
                            maskOperator.updateMask(letter);
                            maskOperator.printMask();
                        } else {
                            mistakesCount++;
                            LOGGER.info("Missed, mistake %s out of 5.\n", mistakesCount);
                            maskOperator.printMask();

                        }
                    }
                    if (mistakesCount == MAX_COUNT_MISTAKES) {
                        LOGGER.info("You lost!");
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    LOGGER.info("congratulations!!!!");
                }
            } else {
                System.exit(0);
            }
            LOGGER.info("Menu: [N]ew game/ [E]xit");
            vubor = scanner.nextLine();
        }
    }
}
