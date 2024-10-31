package com.example.task04;
import java.util.ArrayList;
import java.util.List;


public class MemoryHandler implements MessageHandler {
    private final List<String> messages;
    private final int capacity;
    private final MessageHandler targetHandler;

    public MemoryHandler(int capacity, MessageHandler targetHandler) {
        this.capacity = capacity;
        this.targetHandler = targetHandler;
        this.messages = new ArrayList<>();
    }
    // Добавляет сообщение в буфер, проверяет больше ли размер буфера, чем его вместимость, и если да, то очищает буфер.
    @Override
    public void handle(String message) {
        messages.add(message);
        if (messages.size() >= capacity) {
            flush();
        }
    }

    public void flush() {
        for (String msg : messages) {
            targetHandler.handle(msg);
        }
        messages.clear();
    }
}