package by.tms.instagram.entity.message;

import by.tms.instagram.entity.User;

import java.time.LocalDateTime;

public class PrivateMessage extends Message {
    private boolean isRead;
    public PrivateMessage(LocalDateTime dateTime, User author, String text) {
        this.dateTime = dateTime;
        this.author = author;
        this.text = text;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}
