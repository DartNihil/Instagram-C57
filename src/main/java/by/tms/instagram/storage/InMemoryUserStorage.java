package by.tms.instagram.storage;

import by.tms.instagram.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryUserStorage {

    private final AtomicLong idGenerator = new AtomicLong(0);
    private static final List<User> users = new ArrayList<>();


    public void save(User user) {
        user.setId(idGenerator.incrementAndGet());
        users.add(user);
    }

    public Optional<User> findByNickNameAndEmail(String email, String nick) {
        for (User user : users) {
            if (user.getEmail().equals(email)
                    && user.getNickname().equals(nick)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
    public List<User> getUsers(){
        return users;
    }
}
