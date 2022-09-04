package by.tms.instagram.service;

import by.tms.instagram.entity.Like;
import by.tms.instagram.entity.Post;
import by.tms.instagram.entity.User;
import by.tms.instagram.storage.InMemoryUserStorage;
import by.tms.instagram.storage.UserStorage;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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


    public Optional<User> findByNickNameAndEmail(String nickname, String email) {
        return storage.findByNickNameAndEmail(nickname, email);
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

    public Set<User> checkCoincidencesInNamesAndSurnames(String in) {
        Set<User> setOfFoundUsers = new HashSet<>();
        if (in != null && !in.isEmpty()) {
            for (User user : storage.getUsers()) {
                if (user.getName().contains(in) || user.getSurname().contains(in)) {
                    setOfFoundUsers.add(user);
                }
            }
        }
        return setOfFoundUsers;
    }

    public List<User> getUsers() {
        return storage.getUsers();
    }

    public List<Like> addLikeInHistory(User user, Like like) {
        user.getLikesHistory().add(like);
        return user.getLikesHistory();
    }
}
