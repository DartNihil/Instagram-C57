package by.tms.instagram.service;

import by.tms.instagram.entity.User;
import by.tms.instagram.storage.InMemoryUserStorage;

import java.util.Optional;

public class UserService {
    private final InMemoryUserStorage storage = new InMemoryUserStorage();
    public Optional<User> findByNickNameAndEmail(String email, String nickname){
        return storage.findByNickNameAndEmail(email, nickname);
    };
    public void save(User user){storage.save(user);};
}
