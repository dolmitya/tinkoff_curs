package edu.hw2.task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StableConnection implements Connection {
    private static final String COMPLETE = " выполнена успешно!";
    private static final String CONNECTION = "Соединение для ";
    private static final String CLOSE = " закрыто";
    private static final Logger LOGGER = LogManager.getLogger();

    public void execute(String command) {
        LOGGER.info(command + COMPLETE);
    }

    public void close() {
        LOGGER.info(CONNECTION + this.getClass().getSimpleName() + CLOSE);
    }
}
