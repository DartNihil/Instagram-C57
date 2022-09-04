package by.tms.instagram.service;

import by.tms.instagram.entity.Like;
import by.tms.instagram.entity.Post;
import by.tms.instagram.entity.User;

import java.time.LocalDateTime;

public class PostService {
    private UserService userService = UserService.getInstance();
    private static PostService instance;

    private PostService() {
    }

    public static PostService getInstance() {
        if (instance == null) {
            instance = new PostService();
        }
        return instance;
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

    public Post likePost(User user, User currentUser, Post post, String postDate) {
        if (!post.getLikes().contains(currentUser)) {
            for (Post p:user.getUserPosts()) {
                if(p.getDateTime().toString().equals(postDate) ) {
                    userService.addLikeInHistory(user, new Like(LocalDateTime.now(), currentUser, post));
                    p.getLikes().add(currentUser);
                    post = p;
                }
            }
        }
        else {
            for (Post p:user.getUserPosts()) {
                if(p.getDateTime().toString().equals(postDate) ) {
                    p.getLikes().remove(currentUser);
                    post = p;
                }
            }
        }
        return post;
    }
}
