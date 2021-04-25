package Exceptions;

import java.time.LocalDateTime;

public abstract class Message {
    private String text;
    private LocalDateTime dateTime;

    public Message(String text) {
        this.text = text;
        this.dateTime = LocalDateTime.now();
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "Message{" + "text='" + text + '\'' + ", dateTime=" + dateTime + '}';
    }
}
