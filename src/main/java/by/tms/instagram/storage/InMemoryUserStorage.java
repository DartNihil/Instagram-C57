package by.tms.instagram.storage;

import by.tms.instagram.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryUserStorage implements UserStorage<User, Long> {
    private static InMemoryUserStorage instance;

    private InMemoryUserStorage() {

    }

    public static InMemoryUserStorage getInstance() {
        if (instance == null) {
            instance = new InMemoryUserStorage();
        }
        return instance;
    }

    private final AtomicLong idGenerator = new AtomicLong(0);
    private final List<User> users = new ArrayList<>();

    @Override
    public User save(User user) {
        user.setId(idGenerator.incrementAndGet());
        users.add(user);
        return user;
    }

    @Override
    public Optional<User> getById(Long id) {
        for (User user : users) {
            if (user.getId() == id) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findByNickNameAndEmail(String email, String nick) {
        for (User user : users) {
            if (user.getEmail().equals(email)
                    || user.getNickname().equals(nick)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    @Override
    public void updateUser(String name, String surname, String nickname, String email) {
        Optional<User> user = this.findByNickName(nickname);
        User user1 = user.get();
        user1.setName(name);
        user1.setSurname(surname);
        user1.setNickname(nickname);
        user1.setEmail(email);
    }

    @Override
    public List<String> findNicknamesByTheSamePassword(String password) {
        List<String> nicknames = new ArrayList<>();
        for (User user : users) {
            if (user.getPassword().equals(password)) {
                nicknames.add(user.getNickname());
            }
        }
        return nicknames;
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public Optional<User> findByNickName(String nickname) {
        for (User user : users) {
            if (user.getNickname().equals(nickname)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

}