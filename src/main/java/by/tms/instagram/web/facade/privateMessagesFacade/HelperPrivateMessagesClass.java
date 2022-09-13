package by.tms.instagram.web.facade.privateMessagesFacade;

import by.tms.instagram.entity.User;
import by.tms.instagram.entity.UserComposite;
import by.tms.instagram.entity.message.PrivateMessage;

import java.util.List;

public class HelperPrivateMessagesClass {
    private User user;
    List<UserComposite> userComposites;
    private List<PrivateMessage> privateMessagesOfCurrentUser;

    public HelperPrivateMessagesClass(User user, List<UserComposite> userComposites, List<PrivateMessage> privateMessagesOfCurrentUser) {
        this.user = user;
        this.userComposites = userComposites;
        this.privateMessagesOfCurrentUser = privateMessagesOfCurrentUser;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<UserComposite> getUserComposites() {
        return userComposites;
    }

    public void setUserComposites(List<UserComposite> userComposites) {
        this.userComposites = userComposites;
    }

    public List<PrivateMessage> getPrivateMessagesOfCurrentUser() {
        return privateMessagesOfCurrentUser;
    }

    public void setPrivateMessagesOfCurrentUser(List<PrivateMessage> privateMessagesOfCurrentUser) {
        this.privateMessagesOfCurrentUser = privateMessagesOfCurrentUser;
    }
}
