package by.tms.instagram.service;

import by.tms.instagram.entity.User;
import by.tms.instagram.storage.InMemoryUserStorage;

import java.util.Optional;

public interface UserService {
    default Optional<User> findByNickNameAndEmail(String nickname, String email) {
        return Optional.empty();
    }

    default void save(User user) {

    }
}
