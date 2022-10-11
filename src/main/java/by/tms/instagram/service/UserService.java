package by.tms.instagram.service;

import by.tms.instagram.entity.Like;
import by.tms.instagram.entity.UserHelperComposite;
import by.tms.instagram.entity.message.Message;
import by.tms.instagram.entity.message.PrivateMessage;
import by.tms.instagram.entity.User;
import by.tms.instagram.storage.InMemoryUserStorage;
import by.tms.instagram.storage.UserStorage;

import java.time.LocalDateTime;
import java.util.*;

public class UserService {
    private static UserService instance;

    private UserService() {

    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    private final UserStorage<User, Long> storage = InMemoryUserStorage.getInstance();


    public Optional<User> findByNickNameAndEmail(String email, String nickname) {
        return storage.findByNickNameAndEmail(email, nickname);
    }

    public void save(User user) {
        storage.save(user);
    }

    public void setUserPhoto(User user, String picture) {
        user.setUserPhoto(picture);
    }

    public void removeUserPhoto(User user) {
        user.setUserPhoto(null);
    }

    public Set<User> checkCoincidencesInNamesAndSurnames(String in, long id) {
        Set<User> setOfFoundUsers = new HashSet<>();
        if (in != null && !in.isEmpty()) {
            for (User user : storage.getUsers()) {
                if (user.getName().contains(in) || user.getSurname().contains(in)) {
                    if (user.getId() != id) {
                        setOfFoundUsers.add(user);
                    }
                }
            }
        }
        return setOfFoundUsers;
    }


    public List<User> getUsers() {
        return storage.getUsers();
    }

    public Optional<User> findByNickName(String nickname) {
        return storage.findByNickName(nickname);
    }

    public List<Like> addLikeInHistory(User user, Like like) {
        user.getLikesHistory().add(like);
        return user.getLikesHistory();
    }

    public void addPrivateMessageInMap(User sendMessUser, User takeMessUser, PrivateMessage privateMessage) {
        Map<User, List<PrivateMessage>> privateMessagesOfUser = sendMessUser.getPrivateMessages();
        if (!privateMessagesOfUser.containsKey(takeMessUser)) {
            privateMessagesOfUser.put(takeMessUser, new ArrayList<>());
        }
        List<PrivateMessage> privateMessages = privateMessagesOfUser.get(takeMessUser);
        privateMessages.add(privateMessage);
    }

    public List<UserHelperComposite> getSortedListOfUsersAndLastMessages(User currentUser) {
        Map<User, List<PrivateMessage>> privateMessages = currentUser.getPrivateMessages();
        ArrayList<UserHelperComposite> sortedUsers = new ArrayList<>();
        for (User key : privateMessages.keySet()) {
            List<PrivateMessage> privateMessagesOfUser = privateMessages.get(key);
            Message lastMessageWithUser = privateMessagesOfUser.get(privateMessagesOfUser.size() - 1);
            int count = 0;
            for (PrivateMessage message : privateMessagesOfUser) {
                if (message.getAuthor().equals(key) && !message.isRead()) {
                    count++;
                }
            }
            UserHelperComposite userComposite = new UserHelperComposite(key, lastMessageWithUser, count);
            sortedUsers.add(userComposite);
        }
        return sortedUsers.stream().sorted((o1, o2) -> {
            int result = 0;
            LocalDateTime localDateTimeO1 = o1.getLastMessageWithUser().getDateTime();
            LocalDateTime localDateTimeO2 = o2.getLastMessageWithUser().getDateTime();
            if (localDateTimeO2.isAfter(localDateTimeO2)) {
                result = 1;
            }
            if (localDateTimeO1.isAfter(localDateTimeO2)) {
                result = -1;
            }
            return result;
        }).toList();
    }
}
