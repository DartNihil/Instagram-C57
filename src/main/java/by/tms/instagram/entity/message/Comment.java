package by.tms.instagram.entity.message;

import by.tms.instagram.entity.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Comment extends Message {
    private final List<User> likes = new ArrayList<>();

    public Comment() {
    }

    public Comment(LocalDateTime dateTime, User author, String text) {
        this.dateTime = dateTime;
        this.author = author;
        this.text = text;
    }
    public List<User> getLikes() {
        return likes;
    }
}
