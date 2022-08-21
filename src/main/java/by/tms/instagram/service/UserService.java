package by.tms.instagram.service;

import by.tms.instagram.entity.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findByNickNameAndEmail(String email, String nickname);
    void save(User user);
}
