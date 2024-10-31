package com.example.task04;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements MessageHandler {
    private final String filePath;
    private  FileWriter writer;
    public FileHandler (String filePath) {
        this.filePath = filePath;
        try {
            this.writer = new FileWriter(filePath, true);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void handle(String message) {
        try (FileWriter fileWriter = new FileWriter(filePath, true)) {
            fileWriter.write(message + "\n");
        } catch (IOException ex) {
           ex.printStackTrace();
        }
    }

    public void close() {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}