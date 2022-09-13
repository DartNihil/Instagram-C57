package by.tms.instagram.web.facade.privateMessagesFacade;

import by.tms.instagram.entity.User;
import by.tms.instagram.entity.UserHelperComposite;
import by.tms.instagram.entity.message.PrivateMessage;
import by.tms.instagram.service.MessageService;
import by.tms.instagram.service.UserService;

import java.util.List;

public class PrivateMessagesFacade {
    private final UserService userService = UserService.getInstance();
    private final MessageService messageService = MessageService.getInstance();

    public HelperPrivateMessagesClass getListsOfMessages(String nickname, User currentUser) {
        List<UserHelperComposite> userComposites = userService.getSortedListOfUsersAndLastMessages(currentUser);
        User user;
        if(nickname != null) {
            user = userService.findByNickName(nickname).get();
        } else {
            user = userComposites.get(0).getUser();
        }
        List<PrivateMessage> listOfCurrentUser = currentUser.getPrivateMessages().get(user);
        List<PrivateMessage> listOfUser = currentUser.getPrivateMessages().get(currentUser);
        List<PrivateMessage> privateMessagesOfCurrentUser = messageService.setIsReadMessage(listOfCurrentUser, user);
        messageService.setIsReadMessage(listOfUser, currentUser);
        return new HelperPrivateMessagesClass(user, userComposites, privateMessagesOfCurrentUser);
    }
}
