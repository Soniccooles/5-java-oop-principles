package com.example.task01;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Logger
{

    public enum Level {
        DEBUG(0),
        INFO(1),
        WARNING(2),
        ERROR(3);

        private final int priority;

        Level(int priority) {
            this.priority = priority;
        }
        public int getPriority() { return priority; }
    }

    private static final Map<String, Logger> loggers = new HashMap<>();
    private String name;
    private Level currentLevel = Level.DEBUG;

    public Logger(String name) { this.name = name; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name;}

    public Level getLevel() { return currentLevel; }

    public void setLevel(Level level) { this.currentLevel = level; }

    public void log(Level lvl, String message)
    {
        if (lvl.getPriority() >= currentLevel.getPriority()) {
            String timestamp = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date());
            System.out.printf("[%s] %s %s - %s%n", lvl.name(), timestamp, name, message);
        }
    }

    public static Logger getLogger(String name) {
        return loggers.computeIfAbsent(name, Logger::new);
    }

    public void log(Level lvl, String message, Object... args) {
        log(lvl, String.format(message, args));
    }

    public void debug(String message) {
        log(Level.DEBUG, message);
    }

    public void debug(String message, Object... args) {
        log(Level.DEBUG, message, args);
    }

    public void info(String message) {
        log(Level.INFO, message);
    }

    public void info(String message, Object... args) {
        log(Level.INFO, message, args);
    }

    public void warning(String message) {
        log(Level.WARNING, message);
    }

    public void warning(String message, Object... args) {
        log(Level.WARNING, message, args);
    }

    public void error(String message) {
        log(Level.ERROR, message);
    }

    public void error(String message, Object... args) {
        log(Level.ERROR, message, args);
    }

}
