package edu.project2;

import org.apache.logging.log4j.LogManager;

@SuppressWarnings("uncommentedmain")
public class Project2 {
    private final static int SIZE = 7;
    private final static int BEGIN = 1;
    private final static int END = 5;
    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    private Project2() {
    }

    public static void main(String[] args) {
        Maze lab = new Maze();
        Cell start = new Cell(BEGIN, BEGIN, Cell.Type.PASSAGE, false);
        Cell finish = new Cell(END, END, Cell.Type.PASSAGE, false);
        lab = lab.generate(SIZE, SIZE);
        LOGGER.info("\n" + lab.print() + "\n");
        LOGGER.info("\n" + lab.print(lab.solve(lab, start, finish)));
    }
}
