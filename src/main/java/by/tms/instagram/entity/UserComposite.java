package by.tms.instagram.entity;

import by.tms.instagram.entity.message.Message;

public class UserComposite {
    private User user;
    private Message lastMessageWithUser;

    public UserComposite(User user, Message lastMessageWithUser) {
        this.user = user;
        this.lastMessageWithUser = lastMessageWithUser;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Message getLastMessageWithUser() {
        return lastMessageWithUser;
    }

    public void setLastMessageWithUser(Message lastMessageWithUser) {
        this.lastMessageWithUser = lastMessageWithUser;
    }
}
