package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {
        Logger lgr1 = Logger.getLogger("logger1");
        Logger lgr2 = new Logger("logger2");
        System.out.println(String.join(", ", lgr1.getName(), lgr1.getLevel().toString(), lgr2.getName(), lgr2.getLevel().toString()));
        lgr1.log(Logger.Level.DEBUG, "debug");
        lgr1.setLevel(Logger.Level.ERROR);
        lgr2.setLevel(Logger.Level.INFO);
        System.out.println(String.join(", ", lgr1.getName(), lgr1.getLevel().toString(), lgr2.getName(), lgr2.getLevel().toString()));
        lgr1.debug("Take aim... Seconds remaining: %d", 3);
        lgr2.error("Big error is here! Error code is %d ", 250502);
    }
}
