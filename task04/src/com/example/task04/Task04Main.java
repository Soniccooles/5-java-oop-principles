package com.example.task04;
import java.time.temporal.ChronoUnit;
public class Task04Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("Logger1");
        logger.addHandler(new ConsoleHandler());
        logger.addHandler(new FileHandler("log.txt"));
        logger.addHandler(new RotationFileHandler("rotated_log", ChronoUnit.HOURS));
        logger.addHandler(new MemoryHandler(5, new ConsoleHandler()));
        System.out.println(logger.getHandlers());

        // Логируем сообщения
        logger.debug("This is a debug message.");
        logger.info("This is an info message.");
        logger.warning("This is a warning message.");
        logger.error("This is an error message.");
    }
}
