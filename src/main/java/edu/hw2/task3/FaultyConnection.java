package edu.hw2.task3;

import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FaultyConnection implements Connection {
    private static final String COMPLETE = " выполнена успешно!";
    private static final String CONNECTION = "Соединение для ";
    private static final String CLOSE = " закрыто";
    private static final String ERROR = "Error";
    private static final Logger LOGGER = LogManager.getLogger();
    public final int intBOUND = 2;

    public void execute(String command) throws ConnectionException {
        Random random = new Random();

        if (random.nextInt(intBOUND) == 1) {
            throw new ConnectionException(ERROR, new RuntimeException());
        }
        LOGGER.info(command + COMPLETE);
    }

    public void close() {
        LOGGER.info(CONNECTION + this.getClass().getSimpleName() + CLOSE);
    }
}
