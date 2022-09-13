package by.tms.instagram.web.facade.privateMessagesFacade;

import by.tms.instagram.entity.User;
import by.tms.instagram.entity.UserHelperComposite;
import by.tms.instagram.entity.message.PrivateMessage;

import java.util.List;

public class HelperPrivateMessagesClass {
    private User user;
    List<UserHelperComposite> userComposites;
    private List<PrivateMessage> privateMessagesOfCurrentUser;

    public HelperPrivateMessagesClass(User user, List<UserHelperComposite> userComposites, List<PrivateMessage> privateMessagesOfCurrentUser) {
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

    public List<UserHelperComposite> getUserComposites() {
        return userComposites;
    }

    public void setUserComposites(List<UserHelperComposite> userComposites) {
        this.userComposites = userComposites;
    }

    public List<PrivateMessage> getPrivateMessagesOfCurrentUser() {
        return privateMessagesOfCurrentUser;
    }

    public void setPrivateMessagesOfCurrentUser(List<PrivateMessage> privateMessagesOfCurrentUser) {
        this.privateMessagesOfCurrentUser = privateMessagesOfCurrentUser;
    }
}
