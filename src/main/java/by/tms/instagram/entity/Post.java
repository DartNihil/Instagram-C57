package by.tms.instagram.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Post {
    private LocalDateTime dateTime;
    private String picture;
    private String description;
    private final List<Comment> comments = new ArrayList<>();
    private final List<User> likes = new ArrayList<>();

    public Post() {
    }

    public Post(LocalDateTime dateTime, String picture, String description) {
        this.dateTime = dateTime;
        this.picture = picture;
        this.description = description;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime date) {
        this.dateTime = date;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<User> getLikes() {
        return likes;
    }
}
