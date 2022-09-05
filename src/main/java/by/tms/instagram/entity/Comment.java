package by.tms.instagram.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Comment {
    private LocalDateTime dateTime;
    private User author;
    private String text;
    private final List<User> likes = new ArrayList<>();

    public Comment() {
    }

    public Comment(LocalDateTime dateTime, User author, String text) {
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

    public List<User> getLikes() {
        return likes;
    }
}
