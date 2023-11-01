package edu.hw2.task4;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;

@SuppressWarnings("uncommentedmain")
public class Task4 {
    private Task4() {
    }

    private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    public static CallingInfo callingInfo() {
        Throwable e = new Throwable();
        StackTraceElement[] stktrace = e.getStackTrace();
        String str1 = stktrace[1].toString();
        String str = str1.substring(0, str1.indexOf('('));
        return new CallingInfo(str.substring(0, str.lastIndexOf('.')), str.substring(str.lastIndexOf('.') + 1));
    }

    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        CallingInfo elem = callingInfo();
        LOGGER.info(elem);
        cin.close();
    }

    public record CallingInfo(String className, String methodName) {
    }
}
