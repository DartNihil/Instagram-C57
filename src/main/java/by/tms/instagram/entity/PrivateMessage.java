package by.tms.instagram.entity;

import java.time.LocalDateTime;

public class PrivateMessage {
    private LocalDateTime dateTime;
    private User author;
    private String text;

    public PrivateMessage(LocalDateTime dateTime, User author, String text) {
        this.dateTime = dateTime;
        this.author = author;
        this.text = text;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
