package by.tms.instagram.entity;

import by.tms.instagram.entity.message.Message;

public class UserHelperComposite {
    private User user;
    private Message lastMessageWithUser;

    private int countOfUnreadMessages;

    public UserHelperComposite(User user, Message lastMessageWithUser, int countOfUnreadMessages) {
        this.user = user;
        this.lastMessageWithUser = lastMessageWithUser;
        this.countOfUnreadMessages = countOfUnreadMessages;
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

    public int getCountOfUnreadMessages() {
        return countOfUnreadMessages;
    }

    public void setCountOfUnreadMessages(int countOfUnreadMessages) {
        this.countOfUnreadMessages = countOfUnreadMessages;
    }
}
