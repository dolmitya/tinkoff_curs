package edu.project1;

import java.util.Scanner;
import java.util.Set;
import org.apache.logging.log4j.LogManager;

@SuppressWarnings("uncommentedmain")
public class Game {
    final static int WRONG_COUNT_MISTAKES = -1;
    final static int MAX_COUNT_MISTAKES = 5;
    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();
    private final RandomWordSelector wordSelector = new RandomWordSelector();
    private final WordMask maskOperator = new WordMask();
    int mistakesCount;
    private String letter;

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
                LOGGER.info("\nInput correct letter:");
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
                LOGGER.info("\nA word has been guessed!\nIf you want to give up, enter - give up\n");

                while (!win(maskOperator.getNumberGuessletter(), maskOperator.getWordUniqueLetters())) {
                    LOGGER.info("\nGuess a letter: ");
                    input();
                    if (mistakesCount == WRONG_COUNT_MISTAKES) {
                        LOGGER.info("\nYou give up!");
                        flag = true;
                        break;
                    }
                    if (maskOperator.isLetterbeused(letter)) {
                        LOGGER.info("\nThis letter is already by used!");
                    } else {
                        maskOperator.inputLetterInSet(letter);
                        if (maskOperator.checkLetterinSet(letter)) {
                            LOGGER.info("\nHit!");
                            maskOperator.updateMask(letter);
                            maskOperator.printMask();
                        } else {
                            mistakesCount++;
                            LOGGER.info("\nMissed, mistake " + mistakesCount + " out of 5.\n");
                            maskOperator.printMask();

                        }
                    }
                    if (mistakesCount == MAX_COUNT_MISTAKES) {
                        LOGGER.info("\nYou lost!");
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    LOGGER.info("\nYou won!");
                }
            } else {
                System.exit(0);
            }
            LOGGER.info("\nMenu: [N]ew game/ [E]xit");
            vubor = scanner.nextLine();
        }
    }
}
