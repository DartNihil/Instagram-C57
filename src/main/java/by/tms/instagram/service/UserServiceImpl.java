package by.tms.instagram.service;

import by.tms.instagram.entity.Post;
import by.tms.instagram.entity.User;
import by.tms.instagram.storage.InMemoryUserStorage;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    private final InMemoryUserStorage storage= new InMemoryUserStorage();

    @Override
    public Optional<User> findByNickNameAndEmail(String nickname, String email) {
        return storage.findByNickNameAndEmail(nickname, email);
    }
    @Override
    public void save(User user){
        storage.save(user);
    }
    public Post findPost(User user, String postDate) {
        Post post = new Post();
        for (Post p : user.getUserPosts()) {
            if (p.getDateTime().toString().equals(postDate)) {
                post = p;
            }
        }
        return post;
    }
    public void setUserPhoto(User user, String picture) {
        user.setUserPhoto(picture);
    }
}
