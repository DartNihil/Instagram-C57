package by.tms.instagram.entity.message;

import by.tms.instagram.entity.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Message {
    LocalDateTime dateTime;
    User author;
    String text;

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

    public String getFormatDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm\ndd.MM.yyyy");
        String formatDateTime = dtf.format(dateTime);
        return formatDateTime;
    }
}
