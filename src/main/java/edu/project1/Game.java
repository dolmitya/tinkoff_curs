package edu.project1;

import java.util.Scanner;
import java.util.Set;
import org.apache.logging.log4j.LogManager;

@SuppressWarnings("RegexpSinglelineJava")
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
                System.out.print("\n>Input correct letter:<");
            }
        } while (flag);
    }

    private String inputVubor() {
        Scanner scanner = new Scanner(System.in);
        String result;
        do {
            result = scanner.nextLine();
            if (result.length() == 1 && (result.equals("N") || result.equals("E"))) {
                return result;
            } else {
                System.out.print(">Input correct vubor:\n<");
            }
        } while (true);
    }

    private boolean win(int numberGuessletter, Set<String> wordUniqueLetters) {
        return numberGuessletter == wordUniqueLetters.size();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        String vubor = "N";
        boolean flag;
        while (true) {
            if (vubor.equalsIgnoreCase("N")) {
                mistakesCount = 0;
                flag = false;
                maskOperator.clearBuffer();
                String guessedWord = wordSelector.getRandomWord();
                maskOperator.setWord(guessedWord);
                System.out.print(">A word has been guessed!\n>If you want to give up, enter - give up\n");

                while (!win(maskOperator.getNumberGuessletter(), maskOperator.getWordUniqueLetters())) {
                    System.out.print("\n>Guess a letter: \n<");
                    input();
                    if (mistakesCount == WRONG_COUNT_MISTAKES) {
                        System.out.print("\n>You give up!");
                        flag = true;
                        break;
                    }
                    if (maskOperator.isLetterbeused(letter)) {
                        System.out.print(">\n>This letter is already by used!");
                    } else {
                        maskOperator.inputLetterInSet(letter);
                        if (maskOperator.checkLetterinSet(letter)) {
                            System.out.print(">Hit!\n");
                            maskOperator.updateMask(letter);
                            maskOperator.printMask();
                        } else {
                            mistakesCount++;
                            System.out.print(">Missed, mistake " + mistakesCount + " out of "
                                + MAX_COUNT_MISTAKES + ".\n");
                            maskOperator.printMask();

                        }
                    }
                    if (mistakesCount == MAX_COUNT_MISTAKES) {
                        System.out.print("\n>You lost!");
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    System.out.print("\n>You won!");
                }
            } else {
                System.exit(0);
            }
            System.out.print("\n>Menu: [N]ew game/ [E]xit\n<");
            vubor = inputVubor();
        }
    }
}
