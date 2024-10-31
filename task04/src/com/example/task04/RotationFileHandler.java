package com.example.task04;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler {
    private final String filePrefix;
    private final ChronoUnit rotationUnit;
    private LocalDateTime lastRotationTime;
    private FileWriter currentWriter;

    public RotationFileHandler(String filePrefix, ChronoUnit rotationUnit) {
        this.filePrefix = filePrefix;
        this.rotationUnit = rotationUnit;
        this.lastRotationTime = LocalDateTime.now().truncatedTo(rotationUnit);
        openNewFile();
    }

    private void openNewFile() {
        try {
            if (currentWriter != null) {
                currentWriter.close();
            }
            String fileName = filePrefix + "_" + lastRotationTime.format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")) + ".log";
            currentWriter = new FileWriter(fileName, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handle(String message) {
        LocalDateTime now = LocalDateTime.now().truncatedTo(rotationUnit);
        if (!now.equals(lastRotationTime)) {
            lastRotationTime = now;
            openNewFile();
        }
        try {
            currentWriter.write(message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void close() {
        try
        {
            if (currentWriter != null)
            {
                currentWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
